package com.xiaojiuwo.fastdfsdemo;

import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.csource.common.MyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import com.xiaojiuwo.fastdfsdemo.service.FastDFSService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSTest {

	@Test
	public void uploadAndDownloadTest() throws IOException, MyException {
		Resource resource = new ClassPathResource("WX20170714-164859.png");
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		InputStream inputStream = resource.getInputStream();
		byte[] buff = new byte[1024];
		int rc = 0;
		while ((rc = inputStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		buff = swapStream.toByteArray();
		String filePath = FastDFSService.upload(buff, "png");
		System.out.println(filePath);
		byte[] downloadbuff = FastDFSService.download(filePath);
		assertArrayEquals(buff, downloadbuff);
	}

}
