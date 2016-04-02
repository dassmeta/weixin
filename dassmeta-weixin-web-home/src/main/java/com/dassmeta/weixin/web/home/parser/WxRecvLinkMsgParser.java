package com.dassmeta.weixin.web.home.parser;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvLinkMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;

public class WxRecvLinkMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvLinkMsg parser(Element root, WxRecvMsg msg) throws JDOMException {

		String title = getElementText(root, "Title");
		String description = getElementText(root, "Description");
		String url = getElementText(root, "Url");
		return new WxRecvLinkMsg(msg, title, description, url);
	}

}
