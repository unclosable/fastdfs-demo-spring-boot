package com.xiaojiuwo.fastdfsdemo.utils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils {
	private static ApplicationContext theContext;

	@Resource
	ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		theContext = this.applicationContext;
	}

	public static <T> T getBean(Class<T> theClass) {
		return theContext.getBean(theClass);
	}

	public static Object getBean(String name) {
		return theContext.getBean(name);
	}
}
