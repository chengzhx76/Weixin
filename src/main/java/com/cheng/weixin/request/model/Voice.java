package com.cheng.weixin.request.model;

import java.io.Serializable;

public class Voice implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}