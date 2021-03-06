package xyz.berby.im.server.util;

import org.jim.common.ImPacket;
import org.jim.common.ImStatus;
import org.jim.common.packets.ChatBody;
import org.jim.common.packets.Command;
import org.jim.common.packets.RespBody;
import org.jim.common.utils.ImKit;
import org.tio.core.ChannelContext;

/**
 * Created by Administrator on 2018/10/21.
 * 发送聊天报文工具包
 */
public class CustomKit{


    private static ImPacket sendSuccessRespPacket(ChannelContext channelContext, Object data, Command command) {
        RespBody chatDataInCorrectRespPacket = new RespBody(command, ImStatus.C10000);
        chatDataInCorrectRespPacket.setData(data);
        ImPacket respPacket = ImKit.ConvertRespPacket(chatDataInCorrectRespPacket, channelContext);
        respPacket.setStatus(ImStatus.C10000);
        return respPacket;
    }

    /**
     * 聊天用户不在线响应包
     * @param chatBody
     * @param channelContext
     * @return
     * @throws Exception
     */
    public static ImPacket  offlineRespPacket(ChannelContext channelContext, ChatBody chatBody) throws Exception{
        RespBody chatDataInCorrectRespPacket = new RespBody(Command.COMMAND_CHAT_RESP,ImStatus.C10001);
        chatDataInCorrectRespPacket.setData(chatBody);
        ImPacket respPacket = ImKit.ConvertRespPacket(chatDataInCorrectRespPacket, channelContext);
        respPacket.setStatus(ImStatus.C10001);
        return respPacket;
    }

    public static ImPacket sendChatSuccessRespPacket(ChannelContext channelContext, Object data) throws Exception{
        return sendSuccessRespPacket(channelContext, data, Command.COMMAND_CHAT_RESP);
    }

    public static ImPacket sendHandShakeSuccessRespPacket(ChannelContext channelContext, Object data) {
        return sendSuccessRespPacket(channelContext, data, Command.COMMAND_HANDSHAKE_RESP);
    }

    /**
     * 消息格式不正确响应包
     * @param command
     * @param channelContext
     * @return
     * @throws Exception
     */
    public static ImPacket  dataInCorrectRespPacket(Command command, ChannelContext channelContext) throws Exception{
        RespBody chatDataInCorrectRespPacket = new RespBody(command,ImStatus.C10002);
        ImPacket respPacket = ImKit.ConvertRespPacket(chatDataInCorrectRespPacket, channelContext);
        respPacket.setStatus(ImStatus.C10002);
        return respPacket;
    }
}
