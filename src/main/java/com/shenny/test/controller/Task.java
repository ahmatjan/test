package com.shenny.test.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**   
* @ClassName: Task  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月18日 下午3:35:28  
*/

@Component
public class Task {
	
	//@Scheduled(cron="0/2 * * * * ?")
	public void testJob1()
	{
		System.out.println(UUID.randomUUID().toString()+"\t"+new Date().toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static Integer i;
	public static void main(String[] agr) throws UnsupportedEncodingException
	{
		/*ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
		ctx.getBean("task");*/
		System.out.println("日".getBytes().length);
	}

}
