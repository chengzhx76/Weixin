package com.cheng.weixin.utils;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
/**
 * HTTP请求方法
 * @author Cheng
 */
public class HttpUtils {
	/**
	 * GET 请求
	 * @param url 传入的微信地址
	 * @return 微信返回的消息
	 */
	public static String httpGet(String url) {
		CloseableHttpClient httpClient = null;
		HttpGet httpget = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			httpget = new HttpGet(url);
			response = httpClient.execute(httpget);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				httpget.releaseConnection();
				return content;
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(httpClient!=null) httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(response!=null) response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * POST 请求
	 * @param url 传入的微信地址
	 * @param data 需要发送的JSON参数
	 * @return 微信回复的消息
	 */
	public static String httpPost(String url, String data) {
		CloseableHttpClient httpClient = null;
		HttpPost httppost = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClientBuilder.create().build();
			httppost = new HttpPost(url);
			httppost.setHeader("Content-Type", "application/json");
			StringEntity params = new StringEntity(data,"UTF-8");
			httppost.setEntity(params);
			response = httpClient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				httppost.releaseConnection();
				return content;
			}
		} catch (UnsupportedCharsetException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(httpClient!=null) httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(response!=null) response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
