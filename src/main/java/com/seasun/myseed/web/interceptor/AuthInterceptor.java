package com.seasun.myseed.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seasun.myseed.util.EnvironmentUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;

@Service
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (EnvironmentUtils.isLocalTest()) {
			return true;
		}

		boolean isTokenCheckPassed = false;
		if(isTokenCheckPassed){
			setNoAccessRightInfo(response);
			return false;
		}
		return true;

	}

	private void setNoAccessRightInfo(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		JSONObject returnJson = new JSONObject();
		returnJson.put("code", 401);
		returnJson.put("message", "您没有访问权限，即将跳转");
		returnJson.put("description", "您没有访问权限，即将跳转");

		PrintWriter out = response.getWriter();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		out.append(returnJson.toJSONString());
		out.flush();
		out.close();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}