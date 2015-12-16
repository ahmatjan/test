package com.shenny.test.service;

import java.util.List;

import com.shenny.test.model.BaseChinaCity;

/**   
* @ClassName: IUserService  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午1:34:07  
*/
public interface IUserService {
	
	public List<BaseChinaCity> listAllCity();
	
	public long addData();
	
	public void syncTest();
	
	public boolean buy();

}
