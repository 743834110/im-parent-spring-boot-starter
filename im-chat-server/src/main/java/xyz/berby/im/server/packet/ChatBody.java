package xyz.berby.im.server.packet;

import lombok.Getter;
import lombok.Setter;
import org.jim.common.packets.Message;

/**
 * @author LTF
 * Created on 2019/4/7
 * 聊天消息体
 */
@Getter
@Setter
public class ChatBody extends Message {

    private static final long serialVersionUID = 5731474214655476286L;
    /**
     * 来自channel id;
     */
    private String from;

    private String fromName;

    private String fromAvatar;
    /**
     * 目标channel id;
     */
    private String to;
    /**
     * 消息类型;(如：text、image、voice、video、music、news、file)
     */
    private String msgType;
    /**
     * 聊天类型;(如0:未知，1：公聊、2：私聊)
     */
    private Integer chatType;
    /**
     * 消息内容;
     */
    private String content;
    /**
     * 消息发到哪个群组;
     */
    private String groupId;
}
