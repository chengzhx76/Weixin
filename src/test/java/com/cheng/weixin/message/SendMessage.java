package com.cheng.weixin.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.cheng.weixin.common.WeixinUrl;
import com.cheng.weixin.exception.WeixinException;
import com.cheng.weixin.request.model.ModelMsgData;
import com.cheng.weixin.request.model.TemplateMessage;
import com.cheng.weixin.response.model.SendTemplateMassage;
import com.cheng.weixin.scheduling.RefreshAccessTokenTask;
import com.cheng.weixin.utils.HttpUtils;

public class SendMessage {

	private static final Logger log = LoggerFactory.getLogger(SendMessage.class);
	
	@Test
	public void TemplateMsg() {
		TemplateMessage templateMsg = new TemplateMessage();
		templateMsg.setTouser("oR43ywDiiYX9c_m0N8frmqQsrigk");
		templateMsg.setTemplate_id("tUFdvoE26UP4zN2LLx7E23Pe2TuHFav9CMGXjHO1-Ms");
		templateMsg.setUrl("http://www.baidu.com");
		Map<String, Serializable> map = new HashMap<>();
		map.put("username", new ModelMsgData("Cheng", "#173177"));
		templateMsg.setData(map);
		try {
			String data = JSON.toJSONString(templateMsg);
			
			String url = WeixinUrl.SEND_TEMPLATEMSG_URL.replace("ACCESS_TOKEN", RefreshAccessTokenTask.accessToken);
			System.err.println(data);
			System.err.println(url);
			
			
			String conten =  HttpUtils.httpPost(url, data);
			SendTemplateMassage responMsg = JSON.parseObject(conten, SendTemplateMassage.class);
			System.out.println("消息ID："+responMsg.getMsgid());
		} catch (WeixinException err) {
			log.error("发生错误，错误码：{}，错误消息：{}！", err.getCode(), err.getErrorMsg());
		}
		
	}
	
}