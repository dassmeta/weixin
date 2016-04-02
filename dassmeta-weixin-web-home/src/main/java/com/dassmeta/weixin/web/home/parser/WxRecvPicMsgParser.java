package com.dassmeta.weixin.web.home.parser;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvPicMsg;

public class WxRecvPicMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvPicMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvPicMsg(msg, getElementText(root, "PicUrl"));
	}

}
