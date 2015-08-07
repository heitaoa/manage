package com.poly.action;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class UeditorControllerFilter extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		//
		String url = request.getRequestURI();
		//System.out.println("UeditorControllerFilter -->"+url);
		if ("/adminche/jsp/controller.jsp".equals(url)) {
			System.out.println("ueditor:"+url);
			chain.doFilter(req, res);
		} else {
			super.doFilter(req, res, chain);
		}
	}
}
