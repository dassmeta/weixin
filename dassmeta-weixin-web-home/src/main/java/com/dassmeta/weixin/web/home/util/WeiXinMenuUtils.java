package com.dassmeta.weixin.web.home.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;
import com.dassmeta.util.HttpUtil;

/**
 * 微信自定义菜单创建
 */
public class WeiXinMenuUtils {

	private static final String APPID = "wx478ed4d74425cfa1";
	private static final String APPSECRET = "acda25a330214d212e75e68002c0c421";

	public static void main(String[] args) {
		try {
			// 获取accessToken -参数appid，secret
			String accessToken = getAccessToken(APPID, APPSECRET);
			// // 创建菜单
			String s = "{\"button\":[{\"type\":\"view\",\"name\":\"Dian\",\"url\":\"http://weidian.com/?userid=255082868&wfr=wx_profile\"},{\"name\":\"Wan\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]},{\"name\":\"Cha\",\"sub_button\":[{\"type\":\"view\",\"name\":\"Cha·快递\",\"url\":\"http://weixin.dassmeta.com/express\"}]}]}";

			String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
			try {
				URL url = new URL(action);
				HttpURLConnection http = (HttpURLConnection) url.openConnection();
				http.setRequestMethod("POST");
				http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				http.setDoOutput(true);
				http.setDoInput(true);
				System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
				System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
				http.connect();
				OutputStream os = http.getOutputStream();
				os.write(s.getBytes("UTF-8"));// 传入参数
				os.flush();
				os.close();

				InputStream is = http.getInputStream();
				int size = is.available();
				byte[] jsonBytes = new byte[size];
				is.read(jsonBytes);
				String message = new String(jsonBytes, "UTF-8");
				System.out.println(message);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建菜单
	 */
//	public static String createMenu(Map<String, String> params, String accessToken) throws Exception {
//		String jsonStr = HttpUtil.post("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken,
//				params);
//		JSONObject object = JSONObject.parseObject(jsonStr);
//		return object.getString("errmsg");
//	}

	/**
	 * 获取accessToken
	 */
	public static String getAccessToken(String appid, String secret) throws Exception {
		String response = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appid + "&secret=" + secret);
		JSONObject object = JSONObject.parseObject(response);
		return object.getString("access_token");
	}

	/**
	 * 查询菜单
	 */
	public static String getMenuInfo(String accessToken) throws Exception {
		return HttpUtil.get("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessToken);
	}

	/**
	 * 删除自定义菜单
	 */
	public static String getAccessToken(String accessToken) throws Exception {
		String jsonStr = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + accessToken);
		JSONObject object = JSONObject.parseObject(jsonStr);
		return object.getString("errmsg");
	}
}
