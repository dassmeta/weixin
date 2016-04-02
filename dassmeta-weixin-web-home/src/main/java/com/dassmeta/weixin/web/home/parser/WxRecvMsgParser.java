package com.dassmeta.weixin.web.home.parser;

import org.jdom2.Document;
import org.jdom2.JDOMException;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;

public interface WxRecvMsgParser {
	WxRecvMsg parser(Document doc) throws JDOMException;
}
