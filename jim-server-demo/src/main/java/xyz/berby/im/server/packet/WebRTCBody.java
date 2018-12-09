package xyz.berby.im.server.packet;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jim.common.packets.Message;

/**
 * webRTC消息体
 * @author litianfeng
 */
@Data
@Accessors(chain = true)
public class WebRTCBody extends Message {

    private static final long serialVersionUID = 5731474214655476286L;
    // 来自channel id;
    private String from;
    // 目标channel id;
    private String to;
    // 聊天类型;(如公聊、私聊)
    private Integer chatType;
    // 消息发到哪个群组;
    private String group_id;
    // 会话描述符
    private String sdp;
    // 候选公网IP
    private String candidate;


}
