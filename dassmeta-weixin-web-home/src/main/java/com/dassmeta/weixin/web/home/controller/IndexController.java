package com.dassmeta.weixin.web.home.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dassmeta.weixin.web.home.util.WeiXin;

@Controller
public class IndexController {

	private static final String TOKEN = "weixindassmetawww";

	/** LOGGER */
	private static final Log LOG = LogFactory.getLog(IndexController.class);

	@RequestMapping("/")
	public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		if (LOG.isDebugEnabled()) {
			LOG.info("#INFO#signature=" + signature + ",timestamp=" + timestamp + ",nonce=" + nonce + ",echostr="
					+ echostr);
		}

		WeiXin.access(TOKEN, signature, timestamp, nonce);
		response.getWriter().print(echostr);
	}
}