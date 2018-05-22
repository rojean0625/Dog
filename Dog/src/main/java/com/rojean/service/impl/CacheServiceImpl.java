package com.rojean.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.rojean.service.CacheService;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Resource(name="redisTemplate")
	private ValueOperations<String,String> valueOps;
	
	@Resource(name="redisTemplate")
   private HashOperations<String, String, String> hashOps;

	@Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;
	
	@Resource(name="redisTemplate")
	private SetOperations<String,String> setOps;
//	
//	@Resource(name="redisTemplate")
//	private ZSetOperations<Object,Object> zsetOps;
	

	
	
	
	
	@Override
	public void cahceSet() {
		Map map = new HashMap();
		map.put("k", null);
		//redisTemplate.
		setOps.add("PACKAGE:1", new String[] {"A","B","C","D"});
		setOps.add("PACKAGE:2", new String[] {"C","E","F"});
		setOps.differenceAndStore("PACKAGE:1","PACKAGE:2", "PACKAGE:3");
		System.out.println(setOps.members("PACKAGE:3"));
	}
	
	
	@Override
	public void cacheList() {
		//listOps.leftPushAll("readHistory:2", new String[] {"item4","item5","item6"});
		// listOps.index("readHistory:1", 2)
		String v = listOps.rightPopAndLeftPush("readHistory:3", "readHistory:1", 10, TimeUnit.SECONDS);
		System.out.println("waiting for you:" + v);
	}



	@Override
	public void cacheValue() {
		valueOps.set("rojean", "1", 10, TimeUnit.SECONDS);
		System.out.println(valueOps.get("rojean"));
		
		valueOps.increment("rojean", 1L);
		System.out.println(valueOps.get("rojean"));
		
		valueOps.append("rojean", ":hello");
		System.out.println(valueOps.get("rojean"));
		
		System.out.println(valueOps.get("rojean", 0, 2));
		
		valueOps.set("rojean", "x", 1);
		System.out.println(valueOps.get("rojean"));
		
	}


	@Override
	public void cacheHash() {
		
		//hashOps.put("car:bmw", "type", "320li");
		//hashOps.put("car:bmw",  "price", "320000");
		
		System.out.println(hashOps.get("car:bmw", "type"));
		
		hashOps.increment("car:bmw", "price",200);
		hashOps.increment("car:bmw", "price",-100);
		System.out.println(hashOps.keys("car:bmw"));
		System.out.println(hashOps.values("car:bmw"));
		
	}


	@Override
	public void cacheZset(Object obj) {
		// TODO Auto-generated method stub
		
	}


	




}
