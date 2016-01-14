package com.cheng.weixin.request.model;

import java.io.Serializable;

import com.cheng.weixin.enums.MsgType;
/**
 * 被动回复基类消息
 * @author Cheng
 *
 */
public abstract class BaseMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private MsgType MsgType;
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public MsgType getMsgType() {
		return MsgType;
	}
	public void setMsgType(MsgType msgType) {
		MsgType = msgType;
	}
}
