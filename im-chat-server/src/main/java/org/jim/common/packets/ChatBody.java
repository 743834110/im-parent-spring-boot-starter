package org.jim.common.packets;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @author LTF
 * Created on 2019/4/7
 */
@Setter
@Getter
public class ChatBody extends Message {

    private static final long serialVersionUID = 5731474214655476286L;
    // msgId, 用于标注客户端的消息显示顺序
    private String msgId;
    private String from;//来自channel id;
    private String fromName;
    private String fromAvatar;
    private String to;//目标channel id;
    private String msgType;//消息类型;(如：0:text、1:image、2:voice、3:vedio、4:music、5:news, file)
    private Integer chatType;//聊天类型;(如0, 1公聊、2私聊)
    private String content;//消息内容;
    private String groupId;//消息发到哪个群组;
    // 未读用户
    private String[] read;

}

