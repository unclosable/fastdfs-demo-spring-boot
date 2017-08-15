package com.xiaojiuwo.fastdfsdemo.service;

import javax.annotation.Resource;

import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

@Service
public class ZipkinServer1 {
	@Resource
	private ZipkinServer2 zipkinServer2;

	@NewSpan(name = "zipkinTest")
	public String zipkinTest() {
		zipkinServer2.zipkin1Test();
		zipkinServer2.zipkin2Test();
		return "success";
	}

}
