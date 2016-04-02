package com.dassmeta.weixin.core.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dassmeta.weixin.core.model.ExpressModel;
import com.dassmeta.weixin.core.service.ExpressManager;
import com.dassmeta.weixin.service.integration.express.ExpressClient;

/**
 * 快递查询管理类
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月8日
 */
@Service("expressManager")
public class ExpressManagerImpl implements ExpressManager {
	private static final Logger LOG = LoggerFactory.getLogger(ExpressManagerImpl.class);

	@Resource
	private ExpressClient expressClient;

	@Override
	public ExpressModel query(String postid, String companyName) {
		String queryJson = expressClient.query(companyName, postid);
		if (StringUtils.isBlank(queryJson)) {
			return null;
		}

		try {
			return JSONObject.parseObject(queryJson, ExpressModel.class);
		} catch (Exception e) {
			LOG.error("#ERROR#parse queryJson faild,queryJson=" + queryJson, e);
		}
		return null;
	}

	public void setExpressClient(ExpressClient expressClient) {
		this.expressClient = expressClient;
	}
}
