package com.rojean.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.rojean.service.CacheService;
import com.rojean.service.impl.CacheServiceImpl;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	
	@Bean
	public CacheService cacheService() {
		System.out.println("ini cacheServiceFactory");
		return new CacheServiceImpl();
	}
	
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(10);
		return jedisPoolConfig;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnFactory() {
		JedisConnectionFactory fac = new JedisConnectionFactory();
		fac.setUsePool(true);
		return fac;
	}
	
	@Bean
	public  StringRedisTemplate redisTemplate(){
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
	     try {
	        redisTemplate.setConnectionFactory(jedisConnFactory());
	    } catch (Exception e) {
	    	System.out.println("ini redis error:"+ e+e.getMessage());
	    }
	     return redisTemplate;
	}

}
