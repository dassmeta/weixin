package com.dassmeta.weixin.web.home.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvMsg;
import com.dassmeta.weixin.web.home.vo.send.WxSendMsg;

public final class WxMsgKit {

	private static final Map<String, WxRecvMsgParser> recvParserMap = new HashMap<String, WxRecvMsgParser>();

	static {
		// 文本消息解析程序
		recvParserMap.put("text", new WxRecvTextMsgParser());
		// 链接消息解析程序
		recvParserMap.put("link", new WxRecvLinkMsgParser());
		// 地址消息解析程序
		recvParserMap.put("location", new WxRecvGeoMsgParser());
		// 图片消息解析程序
		recvParserMap.put("image", new WxRecvPicMsgParser());
		// 事件消息解析程序
		recvParserMap.put("event", new WxRecvEventMsgParser());
		// 语音消息解析程序
		recvParserMap.put("voice", new WxRecvVoiceMsgParser());
		// 视频消息解析程序
		recvParserMap.put("video", new WxRecvVideoMsgParser());
	}

	public static WxRecvMsg parse(InputStream in) throws JDOMException, IOException {
		Document dom = new SAXBuilder().build(in);
		Element msgType = dom.getRootElement().getChild("MsgType");
		if (null != msgType) {
			String txt = msgType.getText().toLowerCase();
			WxRecvMsgParser parser = recvParserMap.get(txt);
			if (null != parser) {
				return parser.parser(dom);
			} else {
				System.out.println(txt);
			}
		}
		return null;
	}

	public static Document parse(WxSendMsg msg) throws JDOMException {
		return msg.toDocument();
	}
}
