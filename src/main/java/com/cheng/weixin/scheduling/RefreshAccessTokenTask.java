package com.cheng.weixin.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cheng.weixin.common.WeixinFinalValue;
import com.cheng.weixin.common.WeixinUrl;
import com.cheng.weixin.utils.HttpUtils;

/**
 * 刷新access_token 定时任务
 * @author Cheng
 */
public class RefreshAccessTokenTask {
	
	private static final Logger log = LoggerFactory.getLogger(RefreshAccessTokenTask.class);
	public static String accessToken = "zbUw96_9tNnRZ1nR85ljUARpGXDLeR1LJ09DdcrWWeIzQyRLAlB00JzH-FePCMFEM8ATzvoc44r2cJFe0QRfmJyqYIWkgG8xdSLPcQskVswUOVjAIAEYF";
	
	public void refreshToken() {
		/*
		String url = WeixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinFinalValue.APPID).replace("APPSECRET", WeixinFinalValue.APPSECRET);
		String content = HttpUtils.httpGet(url);
		try {
			AccessToken accessToken = JSON.parseObject(content, AccessToken.class);
			WeixinContent.setAccessToken(accessToken.getAccess_token());
		} catch (Exception e) {
//			e.printStackTrace();
			ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
			log.error("发生错误，错误码：{}，错误消息：{}，正在重试！", err.getErrcode(), err.getErrmsg());
			refreshToken();
		}
	 */
	}
	public static void main(String[] args) {
		String url = WeixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinFinalValue.APPID).replaceAll("APPSECRET", WeixinFinalValue.APPSECRET);
		String content = HttpUtils.httpGet(url);
		System.out.println(content);
		
	}
	
}
