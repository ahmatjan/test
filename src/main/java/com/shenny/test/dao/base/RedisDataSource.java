package com.shenny.test.dao.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @ClassName: RedisDao
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年10月13日 上午10:07:15
 */

@Repository("redisDataSource")
public class RedisDataSource implements IRedisDataSource {

	private static final Logger log = LoggerFactory.getLogger(RedisDataSource.class);

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	public ShardedJedis getRedisClient() {
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			log.error("getRedisClent error", e);
		}
		return null;
	}

	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if (broken) {
			shardedJedisPool.returnBrokenResource(shardedJedis);
		} else {
			shardedJedisPool.returnResource(shardedJedis);
		}
	}

}
