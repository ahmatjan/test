package com.shenny.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shenny.test.model.PostDetail;

/**   
* @ClassName: IPostDetailDao  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年10月22日 上午10:49:17  
*/
public interface IPostDetailDao {
	
	@Select("select id,title,content from posts_detail")
	public List<PostDetail> listAllPost();

}
