package com.cheng.weixin.model;

/**
 * 语音消息
 * @author Cheng
 */
public class VoiceMessage extends BaseMessage {
	
	private Voice Voice;
	
	public Voice getVoice() {
		return Voice;
	}
	public void setVoice(Voice voice) {
		this.Voice = voice;
	}
}
