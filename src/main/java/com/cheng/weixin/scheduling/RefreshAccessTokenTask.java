package com.cheng.weixin.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 刷新access_token 定时任务
 * @author Cheng
 */
public class RefreshAccessTokenTask {
	
	private static final Logger log = LoggerFactory.getLogger(RefreshAccessTokenTask.class);
	public static String accessToken = "qDrEFsAfa6gqolCWjp_MiAQaEpcp_nJyS92GJa6gvr3DI8cVjYmI6v7RdUcGg6fGnGSi2raAwLaS79D4YamU8ZtGXQsgCR_GMQZ1gqibhR4ZJVgACARBN";
	
	public void refreshToken() {
		/*
		String url = WeixinUrl.ACCESS_TOKEN_URL;
		url = url.replace("APPID", WeixinFinalValue.APPID).replace("APPSECRET", WeixinFinalValue.APPSECRET);
		try {
			String content = HttpUtils.httpGet(url);
			AccessToken accessToken = JSON.parseObject(content, AccessToken.class);
			WeixinContent.setAccessToken(accessToken.getAccess_token());
		} catch (BusinessException err) {
//			err.printStackTrace();
			log.error("发生错误，错误码：{}，错误消息：{}，正在重试！", err.getCode(), err.getErrorMsg());
			refreshToken();
		}
	 */
	}
	
}
