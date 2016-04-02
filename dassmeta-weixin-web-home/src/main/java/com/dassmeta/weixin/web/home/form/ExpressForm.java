package com.dassmeta.weixin.web.home.form;

/**
 * 快递查询form
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月8日
 */
public class ExpressForm {
	/**
	 * 快递单号
	 */
	private String postid;

	/**
	 * 公司名称
	 */
	private String typeKey;

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}
	
	

}
