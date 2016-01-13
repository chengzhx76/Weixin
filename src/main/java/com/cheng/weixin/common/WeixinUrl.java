package com.cheng.weixin.common;

public class WeixinUrl {
	/** 获取Access_Token **/
	public static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/** 增加自定义菜单 **/
	public static final String ADDMENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
}
