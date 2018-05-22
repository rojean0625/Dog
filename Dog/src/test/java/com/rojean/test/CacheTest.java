package com.rojean.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.rojean.service.CacheService;

public class CacheTest extends BaseTest {


	@Resource
	CacheService cacheService;
	
	@Test
	public void testCacheHash() {
		cacheService.cacheHash();
	}
	
	public void testCacheSet() {
		cacheService.cahceSet();
	}
	
	public void testCacheList() {
		cacheService.cacheList();
	}
	
	public void testCacheValue(){
		cacheService.cacheValue();
	}
}
