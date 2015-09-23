package com.shenny.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shenny.test.dao.IBaseChinaCityDao;
import com.shenny.test.model.BaseChinaCity;

/**   
* @ClassName: UserService  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午1:34:46  
*/

@Service
@Transactional
public class UserService implements IUserService{
	
	@Inject
	IBaseChinaCityDao baseChinaCityDao;

	@Override
	public List<BaseChinaCity> listAllCity() {
		
		
		return baseChinaCityDao.listAllCity();
	}

}
