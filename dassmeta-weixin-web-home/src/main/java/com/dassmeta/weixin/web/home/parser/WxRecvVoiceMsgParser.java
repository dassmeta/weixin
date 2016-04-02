package com.dassmeta.weixin.web.home.parser;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvVoiceMsg;

/**
 * 微信语音消息解析
 * Created by 0x0001 on 14-9-28.
 */
public class WxRecvVoiceMsgParser extends WxRecvMsgBaseParser {
	@Override
	protected WxRecvMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String mediaID = getElementText(root, "MediaId");
		String format = getElementText(root, "Format");
		String recognition = getElementText(root, "Recognition");
		WxRecvVoiceMsg wxRecvVoiceMsg = new WxRecvVoiceMsg(msg, mediaID, format);
		wxRecvVoiceMsg.setRecognition(recognition);
		return wxRecvVoiceMsg;
	}
}
