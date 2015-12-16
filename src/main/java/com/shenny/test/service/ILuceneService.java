package com.shenny.test.service;

import java.util.List;

import com.shenny.test.model.PostDetail;

/**   
* @ClassName: ILuceneService  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年10月22日 上午10:46:32  
*/
public interface ILuceneService {

	/**
	 * @param query
	 * @return
	 */
	List<PostDetail> query(String query);
	
	List<PostDetail> query(String query,String fieldName);
	
	void addIndex(PostDetail post);
	
	void openIndexWriter();
	void closeIndexWriter();

}
