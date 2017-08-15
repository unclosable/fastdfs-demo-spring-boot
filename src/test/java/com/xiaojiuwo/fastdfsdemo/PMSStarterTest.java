package com.xiaojiuwo.fastdfsdemo;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itiaoling.pmsstarter.api.DataNotFoundException;
import com.itiaoling.pmsstarter.api.EmployeeDeptEntity;
import com.itiaoling.pmsstarter.api.MessageException;
import com.itiaoling.pmsstarter.api.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PMSStarterTest {
	Log logger = LogFactory.getLog(getClass());
	@Resource
	UsersService.Client usersService;
	// @Resource
	// MenuService.Client MenuService;

	@Test
	public void tetetet() throws InterruptedException, ExecutionException, DataNotFoundException, MessageException, TException {
		// for (int i = 0; i < 100000000000l; i++) {
		EmployeeDeptEntity resultEntity = usersService.findEmployeeDeptByid("55560dddd700");
		logger.info(resultEntity);
		// }
		// ExecutorService cachedThreadPool = Executors.newFixedThreadPool(10);
		// for (int i = 0; i < 100000000000l; i++) {
		// UsersService.Client usersService =
		// ApplicationContextUtils.getBean(UsersService.Client.class);
		// cachedThreadPool.execute(() -> {
		// try {
		// EmployeeDeptEntity resultEntity =
		// usersService.findEmployeeDeptByid("55560700");
		// logger.info(resultEntity);
		//
		// } catch (DataNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (TException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// });
		// }
	}
}
