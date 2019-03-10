package com.haliri.israj.config;


import com.haliri.israj.utils.AppUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class CorsConfig extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String origin = request.getHeader("Origin");
		AppUtils.getLogger(this).info("[REST]-[INTERCEPTOR] VALUE ORIGIN {}", origin);

		response.addHeader("Access-Control-Allow-Origin", origin);
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			AppUtils.getLogger(this).info("OPTION CONTROLLER URI [{}] METHOD [OPTIONS] HEADERS [{}]",
					new Object[]{request.getRequestURI(), request.getHeader("Origin")});
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
			response.addHeader("Access-Control-Max-Age", "1");
		}
		return true;
	}
}
