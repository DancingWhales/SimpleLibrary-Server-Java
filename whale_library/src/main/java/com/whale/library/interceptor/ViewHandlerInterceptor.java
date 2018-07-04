package com.whale.library.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class ViewHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ViewHandlerInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ start" + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ end" + request.getRequestURI());
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
