package xyz.berby.im.service.impl;

import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import xyz.berby.im.annotation.Validate;
import xyz.berby.im.dao.AuthDao;
import xyz.berby.im.dao.RoleAuthDao;
import xyz.berby.im.dao.RoleDao;
import xyz.berby.im.dao.UserDao;
import xyz.berby.im.entity.*;
import xyz.berby.im.service.QueryOrgService;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LTF
 * org组件查询服务类，只要囊括多张表的信息查询和写入
 * 该服务类主要是为了解决多表间的复杂业务逻辑的处理
 * Created on 2019/3/9
 */
@Service("queryOrgService")
@Slf4j
@Transactional
public class QueryOrgServiceImpl implements QueryOrgService {

    @Resource
    UserDao userDao;

    @Resource
    AuthDao authDao;

    @Resource
    RoleDao roleDao;

    @Resource
    RoleAuthDao roleAuthDao;

    public void queryServerConfig(List<ServerConfig> configs) {
       System.out.println(configs);
    }

    @Validate("I'm zero")
    public Object upload(Map<String, String[]> map, MultipartFile[] files, User user) {
        return "I am zero";
    }



    /**
     * app端登录业务流程(已解密,使用sha1文本摘要算法)：
     * 1. 从服务器当中获取该登录用户的盐值
     * 2. 对用户密码进行加密操作后和数据库进行比对,知道成功为至
     * 3. 查询用户相关权限和角色，对用户系统操作权限进行管理
     * 4. 将权限数据以树的方式返回前端，并把用户信息保存至session当中。
     */
    @Override
    public User login(User user) {
        User queryUser = new User();
        if (user.getUserAccount() == null || user.getUserPassword() == null) {
            throw new RuntimeException("用户或密码不能为空");
        }
        queryUser.setUserAccount(user.getUserAccount());
        List<User> userList = this.userDao.queryAll(queryUser);

        User queriedUser = userList == null || userList.size() == 0? null: userList.get(0);
        // 判断用户是否存在
        if (queriedUser == null)
            throw new RuntimeException("用户或密码错误");
        String password = new String(SecureUtil.hmacSha1(queryUser.getSalt()).digest(user.getUserPassword()));
        // 判断登录密码是否正确
        if (!password.equals(queriedUser.getUserPassword())) {
            throw new RuntimeException("用户或密码错误");
        }
        // 查询用户所在组织及相关权限
        Role role = this.roleDao.queryById(queriedUser.getRoleId());
        List<RoleAuth> roleAuthList = this.roleAuthDao.queryAll(
                RoleAuth.builder().roleId(role.getRoleId()).build()
        );
        Set<Auth> authSet = new HashSet<>();
        roleAuthList.forEach(roleAuth -> authSet.add(this.authDao.queryById(roleAuth.getAuthId())));
        queriedUser.setRoleList(Collections.singletonList(role));
        queriedUser.setAuthList(new ArrayList<>(authSet));
        return queriedUser;
    }


}
