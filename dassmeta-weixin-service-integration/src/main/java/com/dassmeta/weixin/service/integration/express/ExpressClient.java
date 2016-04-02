package com.dassmeta.weixin.service.integration.express;

import org.springframework.stereotype.Service;

/**
 * 快递查询客户端
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月8日
 */
@Service
public interface ExpressClient {
	public String query(String type, String postid);
}
