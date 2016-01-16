package com.cheng.weixin.token;

import org.junit.Test;

import com.cheng.weixin.common.WeixinFinalValue;
import com.cheng.weixin.common.WeixinUrl;
import com.cheng.weixin.utils.HttpUtils;
import com.cheng.weixin.utils.WeixinContent;

public class AccessToken {
	public static void main(String[] args) {
		String url = WeixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinFinalValue.APPID).replaceAll("APPSECRET", WeixinFinalValue.APPSECRET);
		String content = HttpUtils.httpGet(url);
		System.out.println(content);
	}
	@Test
	public void getToken() {
		System.out.println(WeixinContent.getInstance().getAccessToken());
	}
	
}
