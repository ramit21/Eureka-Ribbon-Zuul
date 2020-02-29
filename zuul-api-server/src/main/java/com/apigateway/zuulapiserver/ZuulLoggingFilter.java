package com.apigateway.zuulapiserver;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
			
	@Override
	public boolean shouldFilter() {
		//logic to decide if filter should be executed
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = 
		RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";// possible values: pre, post, error (request)
	}

	@Override
	public int filterOrder() {
		return 1;//filter order in case of many filters
	}
	
}
