package test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.shenny.test.controller.AopTest;
import com.shenny.test.model.BaseChinaCity;

/**
 * @ClassName: JedisTest
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年7月9日 上午10:49:46
 */
public class JedisTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */

	@AopTest(action = "", name = "")
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/*
		 * Jedis jedis=new Jedis("127.0.0.1"); jedis.set("s","ssss");
		 * jedis.rpush("s1", "sssd"); jedis.lpush("s1", "sssd2");
		 * 
		 * jedis.lpush("s1", "sssd3"); System.out.println(jedis.lrange("s1", 0,
		 * -1));
		 */
		//
		System.out.println(getRandomCode(32,false));
		System.out.println(UUID.randomUUID().toString().replace("-", ""));

	/*	ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream ops = new ObjectOutputStream(out);
			ops.writeObject(new String[] { "s", "dadw" });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = out.toByteArray();
		System.out.println(new String(out.toByteArray()));*/
		ainstan();
	/*	String[] array={"1,2,3","3,4","6,4,6"};
		String[] res=null;
		for(String str:array)
		{
			res=comb(res,str.split(","));
		}
		for(String str:res)
			System.out.println(str);
		
		int a=15421;
		int b=15421;
		System.out.print(a==b);*/
		System.out.println(wordCount("s d "));
		int x=(int)(10/4.0f);
		System.out.println(x);
		BaseChinaCity city=new BaseChinaCity();
		BaseChinaCity city2=new BaseChinaCity();
		city.equals(city2);
		Integer a=143;
		Integer b=143;
		System.out.println(a==b);
		


	}

	static String getRandomCode(int num) {
		return getRandomCode(num,true);
	}
	
	static String getRandomCode(int num, boolean isNum) {
		if (num <= 0)
			return "";
		String str = "";
		Random random = new Random();
		if (isNum) {

			for (int i = 0; i < num; i++) {
				str += random.nextInt(10);
			}
			return str;
		} else {
			String baseChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHHIJKLMNOPQRSTUVWXYZ0123456789";
			for (int i = 0; i < num; i++) {
				str += baseChar.charAt(random.nextInt(baseChar.length()));
			}
			return str;
		}
	}

	static String[] comb(String[] a, String[] b) {
		if (a == null)
			return b;
		else if (b == null)
			return a;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				String str = a[i] + b[j];
				list.add(str);
			}
		}
		return list.toArray(new String[] {});
	}

	static void ainstan() {
		int i = 7;
		while (true) {
			if (i % 2 == 1 && i % 3 == 2 && i % 4 == 3 && i % 5 == 4 && i % 6 == 5) {
				System.out.println(i);
				break;
			}
			i = i + 7;
		}
	}

	static int wordCount(String str) {
		if (str == null)
			return 0;
		char preChar = ' ';
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (preChar != ' ' && str.charAt(i) == ' ')
				count++;
			preChar = str.charAt(i);
		}
		if (preChar != ' ')
			count++;
		return count;
	}
	
	static int subString(String str, int num) {
		int n = 0;
		byte[] array;
		try {
			array = str.getBytes("GBK");
			if (num > array.length)
				return str.length();
			boolean isHalfChinese = false;
			for (int i = 0; i < num; i++) {
				if (array[i] < 0 && !isHalfChinese)
					isHalfChinese = true;
				else {
					n++;
					isHalfChinese = false;
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

}
