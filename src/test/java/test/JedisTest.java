package test;

import java.util.Random;

import com.shenny.test.controller.AopTest;

/**   
* @ClassName: JedisTest  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年7月9日 上午10:49:46  
*/
public class JedisTest {

	/**
	 * @param args
	 */
	
	@AopTest(action = "", name = "")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Jedis jedis=new Jedis("127.0.0.1");
		jedis.set("s","ssss");
		jedis.rpush("s1", "sssd");
		jedis.lpush("s1", "sssd2");

		jedis.lpush("s1", "sssd3");
		System.out.println(jedis.lrange("s1", 0, -1));*/
		
		System.out.println(getRandomCode(6));
		
		

	}
	
	static String getRandomCode(int num) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			str += random.nextInt(10);
		}
		return str;
	}

}
