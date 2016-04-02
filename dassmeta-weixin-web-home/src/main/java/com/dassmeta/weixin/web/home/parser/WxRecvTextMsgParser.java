package com.dassmeta.weixin.web.home.parser;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvTextMsg;

public class WxRecvTextMsgParser extends WxRecvMsgBaseParser{

	@Override
	protected WxRecvTextMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvTextMsg(msg, getElementText(root, "Content"));
	}

	
}
