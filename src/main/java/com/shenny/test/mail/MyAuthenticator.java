package com.shenny.test.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.*;

public class MyAuthenticator extends Authenticator {
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}

	public static void main(String[] args) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("123.125.50.111");// 邮件服务器ip
		// mailInfo.setMailServerHost("10.135.1.205");
		// mailInfo.setMailServerHost("120.192.83.162");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("weibo_hic");
		mailInfo.setPassword("hicweibo_123");// 您的邮箱密码
		mailInfo.setFromAddress("weibo_hic@126.com");
		mailInfo.setToAddress("huagen_zhong@infosys.com");
		mailInfo.setReceivers(new String[]{"billy_ban@infosys.com"});
		mailInfo.setSubject("weibo logs");
		mailInfo.setContent("ssss");
		//mailInfo.setContent("<div style='width:300px;height:300px;background:red url(http://www.baidu.com/img/bdlogo.png) no-repeat fixed center;'>ssssss</div>");
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		//sms.sendTextMail(mailInfo);// 发送文体格式
		SimpleMailSender.sendHtmlMail(mailInfo);// 发送html格式

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm ");
		System.out.println(sdf.format(new Date()));
	}
}
