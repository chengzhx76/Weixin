package com.cheng.weixin.model;

/**
 * 图片消息
 * @author Cheng
 */
public class ImageMessage extends BaseMessage {
	
	private Image Image;
	
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		this.Image = image;
	}
	
}

class Image {
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
