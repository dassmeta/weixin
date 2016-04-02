package com.dassmeta.weixin.service.integration.express.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dassmeta.weixin.common.util.ExpressUtil;
import com.dassmeta.weixin.service.integration.express.ExpressClient;

@Service("expressClient")
public class ExpressClientImpl implements ExpressClient {

	private static final Logger LOG = LoggerFactory.getLogger(ExpressClientImpl.class);

	@Override
	public String query(String comName, String postid) {
		try {
			String type = ExpressUtil.getType(comName);
			return ExpressUtil.query(type, postid);
		} catch (Exception e) {
			LOG.error("#ERROR#query express faild,comName=" + comName + ",postid=" + postid, e);
		}
		return null;
	}

}
