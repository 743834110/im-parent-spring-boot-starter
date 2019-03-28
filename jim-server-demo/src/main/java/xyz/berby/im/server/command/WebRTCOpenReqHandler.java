package xyz.berby.im.server.command;

import org.jim.common.ImAio;
import org.jim.common.ImPacket;
import org.jim.common.ImStatus;
import org.jim.common.packets.Command;
import org.jim.common.packets.RespBody;
import org.jim.common.utils.ChatKit;
import org.jim.common.utils.ImKit;
import org.jim.common.utils.JsonKit;
import org.jim.server.command.AbCmdHandler;
import org.tio.core.ChannelContext;
import xyz.berby.im.server.packet.WebRTCBody;
import xyz.berby.im.server.util.CustomKit;

/**
 * 请求建立webRTC连接处理器
 * 处理流程：
 * <pre>
 *     1. 判断WebRTC聊天范围
 *     2.
 * </pre>
 */
public class WebRTCOpenReqHandler extends AbCmdHandler {
    @Override
    public Command command() {
        return Command.COMMAND_WEB_RTC_OPEN_REQ;
    }

    @Override
    public ImPacket handler(ImPacket packet, ChannelContext channelContext) throws Exception {
        // 暂时不检验消息体的格式
        WebRTCBody rtcBody = JsonKit.toBean(packet.getBody(), WebRTCBody.class);
        Integer chatType = rtcBody.getChatType();
        String to = null;
        String groupId = null;
        String sdp = null;
        String candidate = null;
        ImPacket rtcPacket = new ImPacket(Command.COMMAND_WEB_RTC_OPEN_RESP
                ,new RespBody(Command.COMMAND_WEB_RTC_OPEN_RESP,rtcBody).toByte());
        rtcPacket.setSynSeq(packet.getSynSeq());//设置同步序列号;
        switch (chatType) {
            // 公聊:有一定的限制，但现在就先以这种方式处理。
            case 1:
                groupId = rtcBody.getGroup_id();
                ImAio.sendToGroup(groupId, rtcPacket);
                break;
            // 私聊
            case 2:
                to = rtcBody.getTo();
                // sdp或candidate发给目标用户
                ImAio.sendToUser(to, rtcPacket);
                break;
            default:

        }

        return null;
    }

    /**
     * 检验消息体格式
     * @return
     */
    private boolean validate(WebRTCBody body) {
        return true;
    }
}
