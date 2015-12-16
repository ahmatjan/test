package com.shenny.test.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shenny.test.util.JsoupUtil;

/**   
* @ClassName: Task  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月18日 下午3:35:28  
*/

@Component
public class Task {
	
	//@Scheduled(cron="0 0/30 * * * ?")
	public void testJob1()
	{
		//System.out.println(UUID.randomUUID().toString()+"\t"+new Date().toString());
		try {
			JsoupUtil.getJson("http://news.baidu.com/n?m=rddata&v=hot_word&type=0&date=");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsoupUtil.getWebPage("http://news.baidu.com/");
	}
	static Integer i;
	public static void main(String[] agr) throws UnsupportedEncodingException
	{
		/*ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
		ctx.getBean("task");*/
		System.out.println("ss日".getBytes().length);
	}
	
	//@Scheduled(cron="0/5 * * * * ?")
	public void expressWarning(){
		JsoupUtil.express();
	}
	
	@Scheduled(fixedRate=5000)
	public void testJob2(){
		System.out.println(new Date());
	}

}
