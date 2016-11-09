package com.seasun.myseed.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xionghaitao on 16/5/24.
 */

@Configuration
public class EnvironmentUtils implements ApplicationContextAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentUtils.class);

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		EnvironmentUtils.applicationContext = applicationContext;
	}

	public static boolean isLocalTest() {
		return isTest("local");
	}

	public static boolean isDevTest() {
		return isTest("dev");
	}

	public static boolean isTest(String profile) {
		String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
		for (String temp : activeProfiles) {
			LOGGER.info("Spring Boot 使用profile为:{}", temp);
			if (profile.equalsIgnoreCase(temp)) {
				return true;
			}
		}
		return false;
	}

}
