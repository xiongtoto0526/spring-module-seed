package com.seasun.myseed.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TokenUtils {

	public static String getToken(HttpServletRequest request) {
		String token = request.getHeader("Token");
		return token;
	}

	private static HttpServletRequest getCurrentRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

}
