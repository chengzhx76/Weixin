package com.cheng.weixin.message;

import java.util.Date;

import org.junit.Test;

import com.cheng.weixin.enums.MsgType;
import com.cheng.weixin.request.model.Image;
import com.cheng.weixin.request.model.ImageMessage;
import com.cheng.weixin.request.model.TextMessage;
import com.cheng.weixin.request.model.Voice;
import com.cheng.weixin.request.model.VoiceMessage;
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
		
		System.out.println(XMLUtils.msg2XML(text));
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
		
		System.out.println(XMLUtils.msg2XML(voiceMsg));
	}
	@Test
	public void imageTypeMsgHandle() {
		ImageMessage imgMsg = new ImageMessage();
		imgMsg.setToUserName("chengzhx76");
		imgMsg.setFromUserName("cheng");   
		imgMsg.setCreateTime(new Date().getTime());
		imgMsg.setMsgType(MsgType.image);    
		
		Image img = new Image();
		String mediaId = "M8K2WcayqjRaisQMCygVpWk1VDAjL8XMhvB66Y5TpBHsopHViOEOIR4semy9oOAD";
		img.setMediaId(mediaId);
		imgMsg.setImage(img);
		
		System.out.println(XMLUtils.msg2XML(imgMsg));
	}
}
