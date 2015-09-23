package com.shenny.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shenny.test.model.BaseChinaCity;

/**   
* @ClassName: BaseChinaCityDao  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午1:32:03  
*/
public interface IBaseChinaCityDao {
	
	@Select("select id,name from base_china_city limit 100")
	public List<BaseChinaCity> listAllCity();

}
