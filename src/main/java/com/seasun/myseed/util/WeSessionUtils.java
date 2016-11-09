package com.seasun.myseed.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WeSessionUtils {

	public static String getSession(HttpServletRequest request) {
		String session = request.getHeader("Session");
		return session;
	}


	private static HttpServletRequest getCurrentRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static String getCurrentSession() {
		HttpServletRequest req =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return getSession(req);
	}

}
