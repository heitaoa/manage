package com.poly.action;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class MyFilter extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		// �����˵�url
		String url = request.getRequestURI();
		System.out.println("MyFilter -->"+url);
		if ("/adminCT/jsp/controller.jsp".equals(url)) {
			System.out.println("ʹ���Զ���Ĺ�����");
			chain.doFilter(req, res);
		} else {
			//System.out.println("ʹ��Ĭ�ϵĹ�����");
			super.doFilter(req, res, chain);
		}
	}
}
