package com.cheng.weixin.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static WebApplicationContext wc;
	private static String realpath;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		wc = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		realpath = config.getServletContext().getRealPath("");
	}

	public static WebApplicationContext getWc() {
		return wc;
	}
	public static String getRealpath() {
		return realpath;
	}
}
