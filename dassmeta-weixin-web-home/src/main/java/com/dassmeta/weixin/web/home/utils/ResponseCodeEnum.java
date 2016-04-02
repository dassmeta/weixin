package com.dassmeta.weixin.web.home.utils;

/**
 * 响应码枚举类
 * 
 * @author chenxin@dassmeta.com
 * @creation 2015年11月8日
 */
public enum ResponseCodeEnum {

	SYSTEM_ERROR("系统异常"),

	INSERT_SUCCESS("成功插入配置信息"),

	INSERT_FAILED("插入配置信息失败"),

	UPDATE_SUCCESS("成功更新配置信息"),

	UPDATE_FAILED("更新配置信息失败"),

	DELETE_SUCCESS("成功删除配置信息"),

	DELETE_FAILED("删除配置信息失败"),

	DEF_CONDITION_LIST_INVALID("查询条件列表格式非法"),

	LIMIT_COLS_INVALID("limitCols格式非法"),

	STATISTIC_CONFIG_LIST_INVALID("统计配置列表格式非法"),

	EXTRA_ATTR_INVALID("扩展属性格式非法"),

	COLUMN_LIST_INVALID("模型列格式非法"),

	CHANNEL_LIST_INVALID("外部接口channelList格式非法"),

	UNIQKEY_NOT_EXIST("唯一键不存在"),

	UNIQKEY_ALREADY_EXIST("UniqKey已经存在"),

	MODEL_NAME_NOT_EXIST("模型名不存在"),

	MODEL_NAME_ALREADY_EXIST("模型名已经存在"),

	TABLE_NAME_NOT_EXIST("表名不存在"),

	TABLE_NAME_ALREADY_EXIST("表名已经存在"),

	DUPLICATE_ENTRY_ERROR("重复的唯一键"),

	SOURCE_MODEL_INVALID("模型名不合法：模型名为空或者不存在"),

	UNIQKEY_IS_VALID("唯一键可用"),

	TABLE_NAME_NOT_BLANK("目标表名不能为空"),

	TABLE_NAME_NOT_VALID("目标表名不合法，表名应该存在在SQL语句中"),

	GET_ALL_EXTERNAL_CONFIG_ERROR("查询所有外部接口配置出错"),

	HBASE_INSERT_SUCCESS("成功插入数据"),

	UNIQKEY_NOT_BLANK("接口UniqKey不能为空"),

	OUTPARAMS_INVALID("输出标签选择异常"),

	STATEMENT_INVALID("查询SQL不合法"),

	DATASOURCE_INVALID("数据源不合法"),

	OPERATION_SUCCESS("操作成功"),

	DATAOBJECT_NOT_EXIST("数据对象不存在"), DATAQUERY_DRM_FAILED("查询配置推送失败"),

	APP_NAME_NOT_BLANK("应用方系统名不能为空"), STATEMENT_NOT_BLANK("SQL不能为空"), IN_PARAM_LIST_NOT_BLANK("入参列表不能为空"),

	DATAQUERY_DRM_SUCCESS("查询配置推送成功"), DATAOBJECT_DRM_FAILED("数据对象配置推送失败"),

	DATAOBJECT_DRM_SUCCESS("数据对象配置推送成功"), PARAM_INVALID("参数非法"),

	PARAM_NOT_MATCH("sql中的参数和参数列表中的参数个数不一致"), PARAM_DUPLICATE("参数列表中的参数重复"), QEERY_EXPRESS_ERROR("查询快递失败");

	/** 状态码描述 */
	private String desc;

	/**
	 * 私有构造函数
	 * 
	 * @param desc
	 */
	private ResponseCodeEnum(String desc) {
		this.desc = desc;
	}

	/**
	 * Getter method for property <tt>desc</tt>.
	 * 
	 * @return property value of desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Setter method for property <tt>desc</tt>.
	 * 
	 * @param desc
	 *            value to be assigned to property desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
