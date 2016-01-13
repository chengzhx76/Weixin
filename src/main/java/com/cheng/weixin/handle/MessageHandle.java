package com.cheng.weixin.handle;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cheng.weixin.enums.Event;
import com.cheng.weixin.enums.MsgType;
import com.cheng.weixin.model.TextMessage;
import com.cheng.weixin.utils.XMLUtils;

/**
 * 消息处理类
 * @author Cheng
 */
public class MessageHandle {
	private static final Logger log = LoggerFactory.getLogger(MessageHandle.class);
	
	/**
	 * 把XML转换程Map对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> reqMsg2Map(HttpServletRequest request) {
		Map<String, String> maps = new HashMap<>();
		try {
			String msg = IOUtils.toString(request.getInputStream(),"UTF-8");
			
			log.debug("\n接收到的XML为：\n{}", msg);
			
			Document document = DocumentHelper.parseText(msg);
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for(Element element:elements) {
				maps.put(element.getName(), element.getText());
			}
		} catch (IOException | DocumentException e) {
			log.error("消息转换Map出错！");
			e.printStackTrace();
		}
		return maps;
	}
	
	/**
	 * 返回的消息总入口
	 * @param msgMap
	 * @return
	 */
	public static String handleResp(Map<String, String> msgMap) {
		String msgType = msgMap.get("MsgType");
		String eventType = msgMap.get("Event");
		String content = "请求处理异常，请稍后再试！";
		
		if(eventType!=null) {
			if(Event.unsubscribe.name().equals(eventType)) {
				return handleUnsubscribe(msgMap);
			}else if(MsgType.event.name().equals(msgType)) {
				return handleEvent(msgMap);
			}
		}else if(msgType!=null) {
			if(MsgType.text.name().equals(msgType)||MsgType.voice.name().equals(msgType)
					||MsgType.image.name().equals(msgType)||MsgType.shortvideo.name().equals(msgType)
					||MsgType.location.name().equals(msgType)||MsgType.link.name().equals(msgType)) {
				
				return handleMsg(msgMap);
			}
		}
			
		log.info(content);
		return textTypeMsgHandle(msgMap, content);
	}
	/**
	 * 用户取消订阅
	 * @param msgMap
	 * @return
	 */
	private static String handleUnsubscribe(Map<String, String> msgMap) {
		log.info("用户取消关注！");
		return "success";
	}
	
	/**
	 * 消息处理
	 * @param msgMap
	 * @return
	 */
	private static String handleMsg(Map<String, String> msgMap) {
		String msgType = msgMap.get("MsgType");
		String content = "请求处理消息异常，请稍后再试！";
		
		if(MsgType.text.name().equals(msgType)) {
			content="你发送的是text消息！";
		}else if(MsgType.voice.name().equals(msgType)) {
			content="你发送的是voice消息！";
		}else if(MsgType.image.name().equals(msgType)) {
			content="你发送的是image消息！";
		}else if(MsgType.shortvideo.name().equals(msgType)) {
			content="你发送的是shortvideo消息！";
		}else if(MsgType.location.name().equals(msgType)) {
			content="你发送的是location消息！";
		}else if(MsgType.link.name().equals(msgType)) {
			content="你发送的是link消息！";
		}
		log.info(content);
		return textTypeMsgHandle(msgMap, content);
	}
	/**
	 * 处理事件
	 * @param msgMap
	 * @return
	 */
	private static String handleEvent(Map<String, String> msgMap) {
		String eventType = msgMap.get("Event");
		String content = "请求处理事件类型异常，请稍后再试！";
		
		if(Event.subscribe.name().equals(eventType)) {
			content="谢谢关注！";
		}else if(Event.CLICK.name().equals(eventType)) {
			content="自定义菜单事件！";
		}else if(Event.LOCATION.name().equals(eventType)) {
			content="上报地理位置事件！";
		}else if(Event.SCAN.name().equals(eventType)) {
			content="扫描带参数二维码事件！";
		}else if(Event.VIEW.name().equals(eventType)) {
			content="点击菜单跳转链接时的事件推送！";
		}else if(Event.click.name().equals(eventType)) {
			content="点击推事件！";
		}else if(Event.view.name().equals(eventType)) {
			content="跳转URL！";
		}else if(Event.scancode_push.name().equals(eventType)) {
			content="扫码推事件！";
		}else if(Event.scancode_waitmsg.name().equals(eventType)) {
			content="扫码带提示！";
		}else if(Event.pic_sysphoto.name().equals(eventType)) {
			content="弹出系统拍照发图！";
		}else if(Event.pic_photo_or_album.name().equals(eventType)) {
			content="弹出拍照或者相册发图！";
		}else if(Event.pic_weixin.name().equals(eventType)) {
			content="弹出微信相册发图器！";
		}else if(Event.location_select.name().equals(eventType)) {
			content="弹出地理位置选择器！";
		}else if(Event.media_id.name().equals(eventType)) {
			content="下发消息（除文本消息）！";
		}else if(Event.view_limited.name().equals(eventType)) {
			content="跳转图文消息URL！";
		}
		log.info(content);
		return textTypeMsgHandle(msgMap, content);
	}
	
	/**
	 * 文本消息的处理
	 * @param msgMap
	 * @return
	 */
	private static String textTypeMsgHandle(Map<String, String> msgMap, String content) {
		TextMessage textMsg = new TextMessage();
		textMsg.setToUserName(msgMap.get("FromUserName"));
		textMsg.setFromUserName(msgMap.get("ToUserName"));
		textMsg.setCreateTime(new Date().getTime());
		textMsg.setMsgType(MsgType.text);
		textMsg.setContent(content);
		
		return XMLUtils.textMsg2XML(textMsg);
	}
	
}
