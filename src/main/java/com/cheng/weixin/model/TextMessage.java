package com.cheng.weixin.model;
/**
 * 文本消息
 * @author Cheng
 */
public class TextMessage extends BaseMessage {
	private String Content;

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
}
