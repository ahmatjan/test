package com.shenny.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shenny.test.dao.GoodsMapper;
import com.shenny.test.dao.IBaseChinaCityDao;
import com.shenny.test.dao.IRedisDao;
import com.shenny.test.model.BaseChinaCity;
import com.shenny.test.model.Goods;

/**   
* @ClassName: UserService  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午1:34:46  
*/

@Service
@Transactional
public class UserService implements IUserService{
	
	private Goods goods;
	
	@Inject
	private IBaseChinaCityDao baseChinaCityDao;
	
	@Inject
	private IRedisDao redisDao;
	
	@Inject
	private GoodsMapper goodsDao;
	
	private static int a=0;

	@Override
	public List<BaseChinaCity> listAllCity() {
		
		
		return baseChinaCityDao.listAllCity();
	}

	@Override
	public long addData() {
		
		return redisDao.lpush("user", "5");
	}

	@Override
	public synchronized  void syncTest() {
		System.out.println(a);
		a=a+1;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public  boolean  buy() {
		boolean succ=false;
		synchronized(this){
			if (goods == null)
				goods = goodsDao.selectByPrimaryKey(1);
			if (goods.getNum() > 0) {
				succ = true;
				System.out.println(goods.getNum());
				goods.setNum(goods.getNum() - 1);
			}	
		}
		if (succ) {
			//goodsDao.updateByPrimaryKey(goods);
			return true;
		} else
			return false;
	}

}
