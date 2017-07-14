package com.xiaojiuwo.fastdfsdemo.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Service;

@Service
public class FastDFSService {
	private static FastDFSService dfsService;

	@PostConstruct
	public void init() {
		try {
			ClientGlobal.initByProperties("fastdfs-client.properties");
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		dfsService = this;
	}

	public static void check() {
		if (dfsService == null) {
			throw new RuntimeException("dfs service initialization was failed for some reasons");
		}
	}

	public static String upload(byte[] buff, String fileExtName) throws IOException, MyException {
		check();
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = null;
		try {
			trackerServer = tracker.getConnection();
			StorageServer storageServer = null;
			StorageClient1 client = new StorageClient1(trackerServer, storageServer);
			String fileId = client.upload_file1(buff, fileExtName, null);
			return fileId;
		} catch (IOException | MyException e) {
			throw e;
		} finally {
			trackerServer.close();
		}
	}

	public static byte[] download(String fileURI) throws IOException, MyException {
		check();
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = null;
		try {
			trackerServer = tracker.getConnection();
			StorageServer storageServer = null;
			StorageClient1 client = new StorageClient1(trackerServer, storageServer);
			byte[] re = client.download_file1(fileURI);
			return re;
		} catch (IOException | MyException e) {
			throw e;
		} finally {
			trackerServer.close();
		}
	}
}
