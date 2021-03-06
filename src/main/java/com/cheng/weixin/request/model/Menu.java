package com.cheng.weixin.request.model;

import java.io.Serializable;
import java.util.List;

import com.cheng.weixin.enums.ActionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 自定义菜单
 * @author Cheng
 *
 */
@JsonInclude(Include.NON_NULL)
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ActionType type;
	private String key;
	private String url;
	/** 子菜单 **/
	private List<Menu> sub_button;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ActionType getType() {
		return type;
	}
	public void setType(ActionType type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Menu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<Menu> sub_button) {
		this.sub_button = sub_button;
	}
	
}
