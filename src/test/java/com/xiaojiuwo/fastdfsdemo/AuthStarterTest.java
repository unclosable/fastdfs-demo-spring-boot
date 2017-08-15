package com.xiaojiuwo.fastdfsdemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itiaoling.authstarter.api.DataNotFoundException;
import com.itiaoling.authstarter.api.OauthService;
import com.itiaoling.authstarter.api.TokenEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthStarterTest {

	@Resource
	OauthService.Client OauthService;

	@Test
	public void tetetet() throws InterruptedException, ExecutionException, DataNotFoundException, TException {
		ExecutorService cachedThreadPool = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 1000; i++) {
			Thread.sleep(10);
			cachedThreadPool.execute(() -> {
				TokenEntity entity;
				try {
					entity = OauthService.findTokenByAccessToken("911a7fb1-69e9-4b7a-8670-825d5ef4942c");
					System.out.println(entity.userId);
				} catch (DataNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}

}
