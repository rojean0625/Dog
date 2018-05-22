package com.rojean.service;

public interface CacheService {

	void cacheValue();
	
	void cacheList();
	
	void cahceSet();
	
	void cacheHash();
	
	void cacheZset(Object obj);
}
