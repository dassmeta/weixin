package com.dassmeta.weixin.web.home.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dassmeta.weixin.core.model.ExpressModel;
import com.dassmeta.weixin.core.service.ExpressManager;
import com.dassmeta.weixin.web.home.form.ExpressForm;
import com.dassmeta.weixin.web.home.utils.ResponseCodeEnum;

/**
 * 快递查询服务controller
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月7日
 */
@Controller
public class ExpressController {

	@Resource
	private ExpressManager expressManager;

	/** LOGGER */
	private static final Log LOG = LogFactory.getLog(ExpressController.class);

	@RequestMapping(value = "/express", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "express";
	}

	/**
	 * 快递查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/express.json", method = RequestMethod.POST)
	public String query(Model model, ExpressForm form, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		if (StringUtils.isBlank(form.getPostid()) || StringUtils.isBlank(form.getTypeKey())) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("msg", ResponseCodeEnum.PARAM_INVALID.getDesc());
			LOG.error("#ERROR# query express error, because params invalid!");
			return null;
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("#INFO# execute query express, postid=" + form.getPostid() + ",company=" + form.getTypeKey());
		}

		ExpressModel expressModel = expressManager.query(form.getPostid(), form.getTypeKey());
		if (null == expressModel) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("msg", ResponseCodeEnum.QEERY_EXPRESS_ERROR.getDesc());
			LOG.error("#ERROR# query express error!postid=" + form.getPostid() + ",company=" + form.getTypeKey());
			return null;
		}
		model.addAttribute("expressModel", expressModel);
		model.addAttribute("isSuccess", true);
		return null;
	}

	public void setExpressManager(ExpressManager expressManager) {
		this.expressManager = expressManager;
	}

}