package com.dassmeta.weixin.web.home.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dassmeta.weixin.web.home.vo.recv.WxRecvEventMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvGeoMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvLinkMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvPicMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvTextMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvVideoMsg;
import com.dassmeta.weixin.web.home.vo.recv.WxRecvVoiceMsg;

public class WeixinHandler extends WeixinHandlerAdapter { // WeixinAbstractHandler 继承这个类可以需要实现所有方法

	public WeixinHandler(HttpServletRequest req, HttpServletResponse res, String token) {
		super(req, res, token);
	}

	/**
	 * 收到图片消息
	 *
	 * @param msg
	 */
	@Override
	protected void onPic(WxRecvPicMsg msg) {
		sendText("收到图片消息");
	}

	/**
	 * 收到链接消息
	 *
	 * @param msg
	 */
	@Override
	protected void onLink(WxRecvLinkMsg msg) {
		sendText("收到链接消息");
	}

	/**
	 * 收到地址消息
	 *
	 * @param msg
	 */
	@Override
	protected void onGeo(WxRecvGeoMsg msg) {
		sendText("收到地址消息");
	}

	/**
	 * 收到文本消息
	 *
	 * @param msg
	 */
	@Override
	protected void onText(WxRecvTextMsg msg) {
		sendText("收到文本消息" + msg.getContent() + " FROM :" + msg.getFromUser());
	}

	@Override
	protected void onVoice(WxRecvVoiceMsg wxRecvVoiceMsg) {
		sendText("收到语音消息");
	}

	@Override
	protected void onVideo(WxRecvVideoMsg wxRecvVideoMsg) {
		sendText("收到视频消息");
	}

	/**
	 * 订阅
	 */
	@Override
	protected void onSubscribe(WxRecvEventMsg msg) {
		sendText("感谢您关注");
	}

	/**
	 * 取消订阅
	 */
	@Override
	protected void onUnsubscribe(WxRecvEventMsg msg) {
		System.out.println("取消关注!!!");
	}

	/**
	 * 其它事件 (点击了菜单)
	 *
	 * @param msg
	 */
	@Override
	protected void onOtherEvent(WxRecvEventMsg msg) {
		System.out.println("其它事件: " + msg.getEventKey());
	}
}