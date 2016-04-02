package com.dassmeta.weixin.web.home.parser;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvVideoMsg;

/**
 * 微信视频消息解析
 * Created by 0x0001 on 14-9-28.
 */
public class WxRecvVideoMsgParser extends WxRecvMsgBaseParser {
	@Override
	protected WxRecvMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String mediaID = getElementText(root, "MediaId");
		String thumbMediaId = getElementText(root, "ThumbMediaId");
		return new WxRecvVideoMsg(msg, mediaID, thumbMediaId);
	}
}
