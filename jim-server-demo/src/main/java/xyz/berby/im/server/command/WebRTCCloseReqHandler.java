package xyz.berby.im.server.command;

import org.jim.common.ImPacket;
import org.jim.common.packets.Command;
import org.jim.server.command.AbCmdHandler;
import org.tio.core.ChannelContext;

/**
 * webRTC请求关闭处理器
 * @author li
 *
 */
public class WebRTCCloseReqHandler extends AbCmdHandler {
    @Override
    public Command command() {
        return Command.COMMAND_WEB_RTC_CLOSE_REQ;
    }

    @Override
    public ImPacket handler(ImPacket packet, ChannelContext channelContext) throws Exception {
        return null;
    }
}
