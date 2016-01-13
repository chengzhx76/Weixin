package com.cheng.weixin.utils;

public class WeixinContent {
	private static String accessToken;
	
	public static String getAccessToken() {
		return accessToken;
	}
	public static void setAccessToken(String accessToken) {
		WeixinContent.accessToken = accessToken;
	}
}
