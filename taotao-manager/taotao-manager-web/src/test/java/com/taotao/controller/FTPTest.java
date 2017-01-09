package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {

	@Test
	public void testFtpClient() throws Exception{
		//创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		//创建ftp连接。默认是21端口
		ftpClient.connect("192.168.1.101", 21);
		//登录ftp服务器，使用用户名和密码
		ftpClient.login("ftpuser", "lanjianan");
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//上传文件
		FileInputStream inputStream = new FileInputStream(new File("D:\\picture\\160Q4111U8-4.jpg"));
		System.out.println(inputStream);
		ftpClient.storeFile("hello1.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
	}
	
	@Test
	public void testFtpUtils() throws Exception{
		try {  
	        FileInputStream in=new FileInputStream(new File("D:\\picture\\02.jpg"));  
	        boolean flag = FtpUtil.uploadFile("192.168.1.101", 21, "ftpuser", "lanjianan", "/home/ftpuser/www/images","/2015/01/21", "gaigeming.jpg", in);  
	        System.out.println(flag);  
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    }  
	}
}
