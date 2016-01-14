package com.cheng.weixin.token;

import com.cheng.weixin.common.WeixinFinalValue;
import com.cheng.weixin.common.WeixinUrl;
import com.cheng.weixin.utils.HttpUtils;

public class AccessToken {
	public static void main(String[] args) {
		String url = WeixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinFinalValue.APPID).replaceAll("APPSECRET", WeixinFinalValue.APPSECRET);
		String content = HttpUtils.httpGet(url);
		System.out.println(content);
	}
}
