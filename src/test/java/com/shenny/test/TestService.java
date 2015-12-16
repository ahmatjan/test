package com.shenny.test;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shenny.test.dao.IEcSaleImgDao;
import com.shenny.test.dao.base.IRedisDataSource;
import com.shenny.test.model.PostDetail;
import com.shenny.test.service.ILuceneService;
import com.shenny.test.service.IUserService;

/**
 * @ClassName: TestCase
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月22日 下午1:40:21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestService {

	@Resource(name = "userService")
	IUserService userService;

	@Resource
	IEcSaleImgDao ecSaleImgDao;
	
	//@Resource
	IRedisDataSource redisDao;
	
	@Inject
	ILuceneService luceneService;

	@Test
	public void userServiceTestCase() {
		System.out.println("The userServiceTestCase is started!");
		/*EcSaleImg records=new EcSaleImg();
		records.setSaleId(11);
		records.setCreateTime(new Date());
		records.setUpdateTime(new Date());
		ecSaleImgDao.add(records);
		List<EcSaleImg> list = ecSaleImgDao.listAllImg();
		for (EcSaleImg img : list) {
			System.out.println(img.getId() + "\t" + img.getSaleId() + "\t" + img.getImgUri());
		}*/
		/*ShardedJedis redis=redisDao.getRedisClient();
		redis.set("a", "sadsadasdas");
		System.out.println(redis.get("a"));
		redisDao.returnResource(redis);*/
		List<PostDetail> list=luceneService.query("玻尿下巴");
		System.out.println("The userServiceTestCase is started!");
		for(PostDetail post:list)
		{
			System.out.println(post.getId()+"\t"+post.getTitle()+"\t"+post.getContent());
		}
		
	}

}
