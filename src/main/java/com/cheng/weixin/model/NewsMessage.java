package com.cheng.weixin.model;

import java.util.List;

/**
 * 图文消息
 * @author Cheng
 */
public class NewsMessage extends BaseMessage {
	
	private List<News> Articles;
	
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		this.Articles = articles;
	}
}

class News {
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	
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
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}

}
