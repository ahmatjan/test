package com.shenny.test.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.shenny.test.mail.MailSenderInfo;
import com.shenny.test.mail.SimpleMailSender;

/**
 * @ClassName: JsoupUtil
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月23日 下午1:49:56
 */
public class JsoupUtil {
	
	public static int status;

	public static List<String> getWebPage(String url) {
		Document doc = null;
		List<String> sb = new ArrayList<String>();
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (doc != null) {
			// System.out.println(doc.getElementsByClass("hotnews").html());
			Element e = doc.getElementsByClass("hotnews").get(0);
			for (Element a : e.getElementsByClass("a3")) {
				System.out.println(a.html());
				//writeToFile(a.html());
				sb.add(a.html());
			}
		}
		return sb;
	}

	public static List<String> getJson(String url) throws JSONException {
		List<String> sb = new ArrayList<String>();
		HttpConnection con = new HttpConnection(url, null, null);
		con.invokeGet();
		if (!con.didSucceed())
			return sb;
		JSONObject node = new JSONObject(con.getResponseString());

		JSONArray array = node.getJSONArray("data");
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			System.out.println(obj.getString("title"));
			//writeToFile(obj.getString("title"));
			sb.add(obj.getString("title"));
		}
		return sb;

	}

	public static void writeToFile(String str) {
		File file = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			file = new File("/nfsc/data.txt");
			fos = new FileOutputStream(file, true);
			osw = new OutputStreamWriter(fos, "UTF-8");
			bw = new BufferedWriter(osw);
			bw.write(str + "\n\r");
			bw.close();
			osw.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null)
				bw = null;
			if (osw != null)
				osw = null;
			if (fos != null)
				fos = null;
		}
	}
	
	public static void express(){
		String url="http://www.kuaidi100.com/query?type=yunda&postid=1201903788947&id=1&valicode=&temp=0.16056557465344667";
		HttpConnection con = new HttpConnection(url, null, null);
		con.invokeGet();
		if(con.didSucceed()){
			try {
				JSONObject node = new JSONObject(con.getResponseString());
				JSONArray array=node.getJSONArray("data");
				if(array.length()!=status){
					//sendMsg(array.getJSONObject(0).getString("context"));
					System.out.println(array.toString());
				}
				status=array.length();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void sendMsg(String msg) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.mxhichina.com");
		// mailInfo.setMailServerHost("10.135.1.205");
		// mailInfo.setMailServerHost("120.192.83.162");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("msg@shenny.xyz");
		mailInfo.setPassword("a2566531A");// 您的邮箱密码
		mailInfo.setFromAddress("msg@shenny.xyz");
		mailInfo.setToAddress("shenny520@outlook.com");
		mailInfo.setReceivers(new String[] {"124992608@qq.com"});
		mailInfo.setSubject("E-mail Testing" );
		mailInfo.setContent("<div style='word-break: break-word;font-size: 14px;font-family: \"微软雅黑\";line-height: 25px;'>测试消息：<br>"+msg+"</div>");
		// 这个类主要来发送邮件
		try {
			SimpleMailSender.sendHtmlMail(mailInfo);
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		/*getWebPage("http://news.baidu.com/");
		try {
			getJson("http://news.baidu.com/n?m=rddata&v=hot_word&type=0&date=");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		express();*/
		//sendMsg("hello world!");
		/*File dir=new File("E:/images");
		if(dir.exists()&&dir.isDirectory()){
			System.out.println("The directory is exsits");
			for(File file:dir.listFiles()){
				System.out.println(file.getName());
			}
		}*/
		linkString("asdasd","awdawdwa","wdawdwad");
		
	}
	
	public static void linkString(String... str){
		for(String s:str){
			System.out.println(s);
		}
	}

}
