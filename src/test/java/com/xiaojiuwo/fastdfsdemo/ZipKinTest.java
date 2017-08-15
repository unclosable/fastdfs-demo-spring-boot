package com.xiaojiuwo.fastdfsdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiaojiuwo.fastdfsdemo.service.ZipkinServer1;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipKinTest {
	@Resource
	ZipkinServer1 server1;

	@Test
	public void tttttest(){
		server1.zipkinTest();
	}

}
