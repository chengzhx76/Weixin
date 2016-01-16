package com.cheng.weixin.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheng.weixin.common.WeixinFinalValue;
import com.cheng.weixin.handle.MessageHandle;
import com.cheng.weixin.utils.WeixinContent;

@Controller
public class WeixinController {
	
	private static final Logger log = LoggerFactory.getLogger(WeixinController.class);
	
	@RequestMapping(value="getWxMsg",method=RequestMethod.GET)
	public void initWx(String signature, String timestamp, String nonce, String echostr, HttpServletResponse response) throws IOException {
		if(StringUtils.isNoneBlank(signature, timestamp, nonce, echostr)) {
			String[] arrs = {WeixinFinalValue.WX_TOKEN, timestamp, nonce};
			Arrays.sort(arrs);
			StringBuffer sb = new StringBuffer();
			for(String wx:arrs) {
				sb.append(wx);
			}
			String sha1 = DigestUtils.sha1Hex(sb.toString());
			if(signature.equals(sha1)) {
				response.getWriter().write(echostr);
			}
		}else {
			log.error("参数为空，或缺少参数！");
		}
	}
	
	@RequestMapping(value="getWxMsg",method=RequestMethod.POST)
	public void getWxMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/xml;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Map<String, String> msgMap = MessageHandle.reqMsg2Map(request);
		String respMsg = MessageHandle.handleResp(msgMap);
		
		log.debug("\n回复的XML为：\n{}", respMsg);
		
		response.getWriter().write(respMsg);
		
//		if(null!=respMsg) {
//			response.getWriter().write(respMsg);
//		}else {
//			response.getWriter().write("success");
//		}
	}
	
	@RequestMapping(value="getat",method=RequestMethod.GET)
	public void getAccessToken(HttpServletResponse response) throws IOException {
		response.getWriter().write(WeixinContent.getInstance().getAccessToken());
	}
	
	@RequestMapping("index")
	public String index() {
	    return "index";
	}
}
