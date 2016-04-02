package com.dassmeta.weixin.core.service;

import org.springframework.stereotype.Service;

import com.dassmeta.weixin.core.model.ExpressModel;

/**
 * 快递查询服务
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月8日
 */
@Service
public interface ExpressManager {

	public ExpressModel query(String postid, String companyName);

}
