package com.cheng.weixin.model;

/**
 * 音乐消息
 * @author Cheng
 */
public class MusicMessage extends BaseMessage {
	
	private Music Music;
	
	public Music getMusic() {
		return Music;
	}
	public void setMusic(Music music) {
		this.Music = music;
	}
	
}

class Music {
	private String MediaId;
	private String Title;// 非必须
	private String Description;// 非必须
	private String MusicUrl;// 非必须
	private String HQMusicUrl;// 非必须
	private String ThumbMediaId;// 非必须

	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
}
