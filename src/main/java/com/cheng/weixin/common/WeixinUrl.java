package com.cheng.weixin.common;

public interface WeixinUrl {
	/** 获取Access_Token **/
	String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/** 增加自定义菜单 **/
	String ADDMENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	/** 新增临时素材 **/
	String ADD_TEMPMEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	/** 获取媒体素材  **/
	String GET_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	/** 发送模板消息 **/
	String SEND_TEMPLATEMSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

}
