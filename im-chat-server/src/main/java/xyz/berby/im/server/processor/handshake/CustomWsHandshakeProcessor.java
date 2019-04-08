/**
 * 
 */
package xyz.berby.im.server.processor.handshake;

import org.jim.common.ImAio;
import org.jim.common.ImPacket;
import org.jim.common.packets.Command;
import org.jim.common.packets.RespBody;
import org.jim.server.command.handler.processor.handshake.WsHandshakeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.tio.core.ChannelContext;
import xyz.berby.im.property.DefaultSettingProperty;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author litianfeng
 * Created on 2018/10/27
 * 握手成功后
 * 发送密钥到客户端当中
 * 以完成登录信息加密操作
 */
public class CustomWsHandshakeProcessor extends WsHandshakeProcessor{

	@Autowired
	private DefaultSettingProperty property;

	@Override
	public void onAfterHandshaked(ImPacket packet, ChannelContext channelContext) throws Exception {

		Map<String, Object> map = new HashMap<>();
		map.put(DefaultSettingProperty.PUBLIC_KEY, this.property.getSetting().get(DefaultSettingProperty.PUBLIC_KEY));
		RespBody respBody = new RespBody(Command.COMMAND_HANDSHAKE_RESP, map);
		ImPacket imPacket = new ImPacket(respBody.toByte());
		ImAio.send(channelContext, imPacket);

	}

}
