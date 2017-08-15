package com.xiaojiuwo.fastdfsdemo.service;

import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.xiaojiuwo.fastdfsdemo.utils.ApplicationContextUtils;

@Service
public class ZipkinServer2 {

	@NewSpan(name = "zipkinTest2")
	public long zipkin1Test() {
		long re = 0;
		for (int i = 0; i < 100000; i++) {
			re += i;
		}
		re += ApplicationContextUtils.getBean(ZipkinServer2.class).zipkin2Test();
		return re;
	}

	@NewSpan(name = "zipkinTest3")
	public long zipkin2Test() {
		long re = 0;
		for (int i = 0; i < 100000; i++) {
			re += i;
		}
		return re;
	}

}
