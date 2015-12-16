package com.shenny.test.dao;

import java.util.List;

import com.shenny.test.model.EcSaleImg;

/**   
* @ClassName: IEcSaleImgDao  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年9月22日 下午2:53:07  
*/
public interface IEcSaleImgDao {
	
	public List<EcSaleImg> listAllImg();
	
	public int add(EcSaleImg img);
	
	public int insert(String str);

}
