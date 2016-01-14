package com.cheng.weixin.media;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.common.WeixinUrl;
import com.cheng.weixin.enums.MidiaType;
import com.cheng.weixin.exception.BusinessException;
import com.cheng.weixin.response.model.Media;
import com.cheng.weixin.scheduling.RefreshAccessTokenTask;
import com.cheng.weixin.utils.HttpUtils;

public class MediaManger {
	private static final Logger log = LoggerFactory.getLogger(MediaManger.class);
	
	@Test
	public void addTempMidia() {
		String url = WeixinUrl.ADD_TEMPMEDIA_URL;
		url = url.replace("ACCESS_TOKEN", RefreshAccessTokenTask.accessToken).replace("TYPE", MidiaType.image.name());
		
		try {
			String content = HttpUtils.postMedia(url, "C:\\Picture\\g.jpg");
			Media media = JSON.parseObject(content, Media.class);
			System.out.println(media);
		} catch (BusinessException err) {
			log.error("发生错误，错误码：{}，错误消息：{}", err.getCode(), err.getErrorMsg());
		}
	}
	@Test
	public void getMedie() {
		String url = WeixinUrl.GET_MEDIA_URL;
		String mediaId = "M8K2WcayqjRaisQMCygVpWk1VDAjL8XMhvB66Y5TpBHsopHViOEOIR4semy9oOAD";
		url = url.replace("ACCESS_TOKEN", RefreshAccessTokenTask.accessToken).replace("MEDIA_ID", mediaId);
		try {
			HttpUtils.getMidie(url, "D:\\1.jpg");
		} catch (BusinessException err) {
//			e.printStackTrace();
			log.error("发生错误，错误码：{}，错误消息：{}", err.getCode(), err.getErrorMsg());
		}
		
	}
	
}
