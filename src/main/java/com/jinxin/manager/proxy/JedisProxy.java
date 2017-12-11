package com.jinxin.manager.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by yezhangyuan on 2017-12-11.
 *
 * @author yezhangyuan
 */
@Component
public class JedisProxy {

	private static final Logger LOGGER = LoggerFactory.getLogger(JedisProxy.class);
	/**
	 * redis主机地址
	 */
	private String redisAddr;
	/**
	 * redis 端口
	 */
	private Integer port;
	/**
	 * jedis 客户端
	 */
	private Jedis jedisClient;

	public JedisProxy(String redisAddr, Integer port) {
		this.redisAddr = redisAddr;
		this.port = port;
		try {
			this.jedisClient = new Jedis(redisAddr, port);
		} catch (Exception e) {
			LOGGER.error("redis connect occur error", e);
		}
	}

	/**
	 * 设置字符串键值对
	 *
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
		try {
			jedisClient.set(key, value);
		} catch (Exception e) {
			LOGGER.error("redis set kv error", e);
		}
	}

	/**
	 * 获取键值
	 *
	 * @param key
	 * @return
	 */
	public String get(String key) {
		try {
			return this.jedisClient.get(key);
		} catch (Exception e) {
			LOGGER.error("redis get v error", e);
		}
		return "";
	}


}
