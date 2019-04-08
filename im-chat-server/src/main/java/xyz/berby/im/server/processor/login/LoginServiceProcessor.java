/**
 * 
 */
package xyz.berby.im.server.processor.login;

import java.util.*;
import java.util.stream.Collectors;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jim.common.Const;
import org.jim.common.ImPacket;
import org.jim.common.ImSessionContext;
import org.jim.common.ImStatus;
import org.jim.common.packets.*;
import org.jim.common.utils.JsonKit;
import org.jim.server.command.CommandManager;
import org.jim.server.command.handler.JoinGroupReqHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.tio.core.ChannelContext;
import org.jim.common.http.HttpConst;
import org.jim.common.utils.Md5;
import org.jim.server.command.handler.processor.login.LoginProcessorIntf;

import xyz.berby.im.entity.ChatGroup;
import xyz.berby.im.entity.UserOrg;
import xyz.berby.im.entity.WorkGroupMember;
import xyz.berby.im.property.DefaultSettingProperty;
import xyz.berby.im.service.ChatGroupService;
import xyz.berby.im.service.UserOrgService;
import xyz.berby.im.service.WorkGroupMemberService;
import xyz.berby.im.service.app.AppUserService;
import xyz.berby.im.util.JwtUtil;
import xyz.berby.im.vo.Pager;

/**
 * @author WChao
 *
 */
public class LoginServiceProcessor implements LoginProcessorIntf{

	private Logger logger = LoggerFactory.getLogger(LoginServiceProcessor.class);


	public static final Map<String, User> tokenMap = Collections.synchronizedMap(new WeakHashMap<>());


	@Autowired
	private AppUserService appUserService;

	@Autowired
	private ChatGroupService chatGroupService;

	@Autowired
	private WorkGroupMemberService workGroupMemberService;

	@Autowired
	private UserOrgService userOrgService;

	@Autowired
	private DefaultSettingProperty property;

	/**
	 * 根据用户名和密码获取用户
	 * @param loginname
	 * @param password
	 * @return
	 * @author: WChao
	 */
	public User getUser(String loginname, String password) {
		String text = loginname+password;
		String key = Const.authkey;
		String token = Md5.sign(text, key, HttpConst.CHARSET_NAME);
		User user = tokenMap.get(token);
		if (user == null) {
			xyz.berby.im.entity.User tempUser = null;
			try {
				tempUser = this.appUserService.login(
						xyz.berby.im.entity.User.builder()
								.userAccount(loginname)
								.userPassword(password)
								.build()
				);

				// 设置user值
				user = new User(tempUser.getUserId(), tempUser.getUserName());
				user.setAvatar(tempUser.getUserImageUrl());
				List<Group> groupList = initGroups(user);
				user.setGroups(groupList);
				// 设置token
				JSONObject userFeature = new JSONObject();
				userFeature.put("userAccount", loginname);
				userFeature.put("userPassword", password);
                String tokenString = JwtUtil.createJWT(
                		userFeature.toJSONString(),
                        1000 * 60 * 60 * 24,
                        (String) this.property.getSetting().get(DefaultSettingProperty.PUBLIC_KEY)
                );
                user.setExtras(new JSONObject(new HashMap<String, Object>() {
                    {
                        this.put("token", tokenString);
                    }
                }));
                if (tokenMap.size() > 10000) {
                	tokenMap.clear();
				}
                tokenMap.put(tokenString, user);


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	/**
	 * 根据token获取用户信息
	 * @param token 此token是每个系统间的通讯共识
	 * @return user
	 */
	public User getUser(String token) {
		//demo中用map，生产环境需要用cache

		User user = tokenMap.get(token);
//			if (tokenMap.size() > 10000) {
//				tokenMap.clear();
//			}
//			tokenMap.put(token, user);
//		}
		return user;
	}

    /**
     * 初始化群组
     * @param user
     * @return
     */
	private List<Group> initGroups(User user){

		// 查找用户所属组织
		Pager<UserOrg> userOrgPager = this.userOrgService.queryByPagerWithNoCount(new Pager<>(UserOrg.builder()
				.userId(user.getId())
				.build()));

		// 根据组织查找所处的chatGroup
		List<ChatGroup> groupList = new ArrayList<>();
		userOrgPager.getResult().parallelStream().forEach(userOrg -> {
			Pager<ChatGroup> chatGroupPager = this.chatGroupService.queryByPagerWithNoCount(new Pager<>(ChatGroup
					.builder()
					.orgId(userOrg.getOrgId())
					.build()));
			groupList.addAll(chatGroupPager.getResult());
		});


		// 尝试lambda写法
		return groupList.parallelStream().map(chatGroup -> {
			Group group = new Group(chatGroup.getGroupId(), chatGroup.getName());
			group.setAvatar(chatGroup.getAvatar());

			// 初始化群组内成员
            Pager<WorkGroupMember> workGroupMemberPager = this.workGroupMemberService.queryByPagerWithNoCount(new Pager<>(WorkGroupMember
                    .builder()
                    .chatGroupId(group.getGroup_id())
                    .build())
            );
            List<User> userList = workGroupMemberPager.getResult().parallelStream().map(workGroupMember -> {
                User groupMember = new User(workGroupMember.getUserId(), workGroupMember.getUserName());
                groupMember.setAvatar(workGroupMember.getMemberImageUrl());
                return  groupMember;
            }).collect(Collectors.toList());
            group.setUsers(userList);
			return group;
		}).collect(Collectors.toList());
	}
	
	/**
	 * doLogin方法注意：J-IM登陆命令是根据user是否为空判断是否登陆成功,
	 * **非常重要**
	 * 当登陆失败时设置user属性需要为空，相反登陆成功user属性是必须非空的;
	 */
	@Override
	public LoginRespBody doLogin(LoginReqBody loginReqBody , ChannelContext channelContext) {
		String loginname = loginReqBody.getLoginname();
		String password = loginReqBody.getPassword();
		ImSessionContext imSessionContext = (ImSessionContext)channelContext.getAttribute();
		String handshakeToken = imSessionContext.getToken();
		User user;
		LoginRespBody loginRespBody;
		if (!StringUtils.isBlank(handshakeToken)) {
			user = this.getUser(handshakeToken);
		}else{
			user = this.getUser(loginname, password);
		}
		if(user == null){
			loginRespBody = new LoginRespBody(Command.COMMAND_LOGIN_RESP,ImStatus.C10008);
		}else{
			loginRespBody = new LoginRespBody(Command.COMMAND_LOGIN_RESP,ImStatus.C10007,user);
		}
		return loginRespBody;
	}

	@Override
	public void onSuccess(ChannelContext channelContext) {
		logger.info("登录成功回调方法");
		ImSessionContext imSessionContext = (ImSessionContext)channelContext.getAttribute();
		User user = imSessionContext.getClient().getUser();
		if(user.getGroups() != null){
			for(Group group : user.getGroups()){//发送加入群组通知
				ImPacket groupPacket = new ImPacket(Command.COMMAND_JOIN_GROUP_REQ,JsonKit.toJsonBytes(group));
				try {
					JoinGroupReqHandler joinGroupReqHandler = CommandManager.getCommand(Command.COMMAND_JOIN_GROUP_REQ, JoinGroupReqHandler.class);
					joinGroupReqHandler.joinGroupNotify(groupPacket, channelContext);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean isProtocol(ChannelContext channelContext) {
		 
		return true;
	}

	@Override
	public String name() {
		
		return "default";
	}
}
