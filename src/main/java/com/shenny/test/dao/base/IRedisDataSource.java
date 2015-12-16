package com.shenny.test.dao.base;

import redis.clients.jedis.ShardedJedis;

/**   
* @ClassName: IRedisDataSource  
* @Description:
* @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>   
* @date 2015年10月13日 上午10:06:17  
*/
public interface IRedisDataSource {
	public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
