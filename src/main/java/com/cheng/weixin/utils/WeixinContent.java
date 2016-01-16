package com.cheng.weixin.utils;

public class WeixinContent {
	
	private WeixinContent(){}
	
	private static class SingletonHolder {
		public static final WeixinContent instance = new WeixinContent();
	}
	
	public static WeixinContent getInstance() {
		return SingletonHolder.instance;
	}
	
//	private String accessToken;
	private static String accessToken = "J_K2FG4Bz_kSjENzuIs2kraEBPkV2WQn-lQgBUoev50gRtsnc_VtQnRt6laqgbZPXjPgu-oGoBp8Hokw9m49daK1gSETefLYRiLNb-o-PlwLBXjAEAEUQ";
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
