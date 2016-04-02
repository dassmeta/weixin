package com.dassmeta.weixin.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.dassmeta.util.HttpUtil;

public class ExpressUtil {
	private static Map<String, String> comCodeMap = new HashMap<String, String>();
	private static final String URL = "http://baidu.kuaidi100.com/query";
	private static final String ID = "4";

	static {
		comCodeMap.put("EMS", "ems");
		comCodeMap.put("申通", "shentong");
		comCodeMap.put("圆通", "yuantong");
		comCodeMap.put("中通", "zhongtong");
		comCodeMap.put("汇通", "huitongkuaidi");
		comCodeMap.put("E邮宝", "ems");
		comCodeMap.put("UPS", "ups");
		comCodeMap.put("顺丰", "shunfeng");
		comCodeMap.put("韵达", "yunda");
		comCodeMap.put("天天", "tiantian");
		comCodeMap.put("宅急送", "zhaijisong");
		comCodeMap.put("邮政包裹", "youzhengguonei");
		comCodeMap.put("AAE", "aae");
		comCodeMap.put("安信达", "anxindakuaixi");
		comCodeMap.put("BHT", "bht");
		comCodeMap.put("百福东方", "aae");
		comCodeMap.put("包裹/平邮/挂号信", "youzhengguonei");
		comCodeMap.put("COE", "coe");
		comCodeMap.put("CCES（希伊艾斯）", "cces");
		comCodeMap.put("DHL", "dhl");
		comCodeMap.put("大田", "datianwuliu");
		comCodeMap.put("德邦", "debangwuliu");
		comCodeMap.put("D速", "dsukuaidi");
		comCodeMap.put("递四方", "disifang");
		comCodeMap.put("飞康达", "feikangda");
		comCodeMap.put("FedEx（国际）", "fedex");
		comCodeMap.put("凡客", "rufengda");
		comCodeMap.put("能达速递", "ganzhongnengda");
		comCodeMap.put("挂号信", "youzhengguonei");
		comCodeMap.put("共速达", "gongsuda");
		comCodeMap.put("京广", "jinguangsudikuaijian");
		comCodeMap.put("佳吉", "jiajiwuliu");
		comCodeMap.put("佳怡", "jiayiwuliu");
		comCodeMap.put("急先达", "jixianda");
		comCodeMap.put("龙邦", "longbanwuliu");
		comCodeMap.put("联昊通", "lianhaowuliu");
		comCodeMap.put("联邦快递（国内）", "lianbangkuaidi");
		comCodeMap.put("全一", "quanyikuaidi");
		comCodeMap.put("全晨", "quanchenkuaidi");
		comCodeMap.put("全日通", "quanritongkuaidi");
		comCodeMap.put("全峰", "quanfengkuaidi");
		comCodeMap.put("速尔", "suer");
		comCodeMap.put("盛辉", "shenghuiwuliu");
		comCodeMap.put("申通E物流", "shentong");
		comCodeMap.put("穗佳物流", "suijiawuliu");
		comCodeMap.put("TNT", "tnt");
		comCodeMap.put("天地华宇", "tiandihuayu");
		comCodeMap.put("特快专递", "ems");
		comCodeMap.put("新邦", "xinbangwuliu");
		comCodeMap.put("信丰", "xinfengwuliu");
		comCodeMap.put("鑫飞鸿", "xinhongyukuaidi");
		comCodeMap.put("星晨急便", "xingchengjibian");
		comCodeMap.put("优速", "youshuwuliu");
		comCodeMap.put("运通", "yuntongkuaidi");
		comCodeMap.put("源伟丰", "yuanweifeng");
		comCodeMap.put("远成", "yuanchengwuliu");
		comCodeMap.put("越丰", "yuefengwuliu");
		comCodeMap.put("亚风", "yafengsudi");
		comCodeMap.put("元智捷诚", "yuanzhijiecheng");
		comCodeMap.put("邮政国内包裹", "youzhengguonei");
		comCodeMap.put("邮政国际包裹", "youzhengguoji");
		comCodeMap.put("中铁快运", "zhongtiewuliu");
		comCodeMap.put("中邮物流", "zhongyouwuliu");
	}

	public static String getType(String comName) {
		if (StringUtils.isBlank(comName)) {
			new IllegalArgumentException("comName is not null.");
		}
		String comCode = comCodeMap.get(comName);
		if (StringUtils.isBlank(comCode)) {
			new IllegalArgumentException("no support comName,comName=" + comName);
		}
		return comCode;
	}

	public static String query(String type, String postid) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", type);
		params.put("postid", postid);
		params.put("id", ID);
		return HttpUtil.post(URL, params);
	}
}
