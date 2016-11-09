package com.seasun.myseed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.seasun.myseed.web.interceptor.AuthInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private AuthInterceptor authInterceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor).addPathPatterns("/apis/auth/**").excludePathPatterns("/apis/pub/**");
	}
}
