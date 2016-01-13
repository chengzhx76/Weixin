package com.cheng.weixin.message;

import java.util.Date;

import org.junit.Test;

import com.cheng.weixin.enums.MsgType;
import com.cheng.weixin.model.TextMessage;
import com.cheng.weixin.model.Voice;
import com.cheng.weixin.model.VoiceMessage;
import com.cheng.weixin.utils.XMLUtils;

public class MsgToXML {
//	@Test
	public void textMsg2XML() {
		TextMessage text = new TextMessage();
		text.setToUserName("chengzhx76");
		text.setFromUserName("cheng");
		text.setCreateTime(new Date().getTime());
		text.setContent("hello!");
		text.setMsgType(MsgType.text);
		
		System.out.println(XMLUtils.textMsg2XML(text));
	}
	
	@Test
	public void voiceMsg2XML() {
		VoiceMessage voiceMsg = new VoiceMessage();
		voiceMsg.setToUserName("chengzhx76");
		voiceMsg.setFromUserName("cheng");
		voiceMsg.setCreateTime(new Date().getTime());
		voiceMsg.setMsgType(MsgType.voice);
		Voice voice = new Voice();
		voice.setMediaId("523646324131");
		voiceMsg.setVoice(voice);
		
		System.out.println(XMLUtils.voiceMsg2XML(voiceMsg));
	}
	
}
