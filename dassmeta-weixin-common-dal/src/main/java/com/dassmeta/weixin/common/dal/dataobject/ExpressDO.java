package com.dassmeta.weixin.common.dal.dataobject;

import java.io.Serializable;

/**
 * 快递查询DO
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月8日
 */
public class ExpressDO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4104727825031781883L;
	
	private String message;
	/**
	 * 快递单号
	 */
	private String nu;
	private String ischeck;
	/**
	 * 快递公司名称
	 */
	private String com;
	private String status;
	private String condition;
	/**
	 * 快递单当前的状态 ：
	 * 0：在途，即货物处于运输过程中；
	 * 1：揽件，货物已由快递公司揽收并且产生了第一条跟踪信息；
 	 * 2：疑难，货物寄送过程出了问题；
	 * 3：签收，收件人已签收；
	 * 4：退签，即货物由于用户拒签、超区等原因退回，而且发件人已经签收；
	 * 5：派件，即快递正在进行同城派件；
	 * 6：退回，货物正处于退回发件人的途中；
	 */
	private String state;
	/**
	 * json字符串
	 */
	private String data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNu() {
		return nu;
	}
	public void setNu(String nu) {
		this.nu = nu;
	}
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
