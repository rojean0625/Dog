package com.rojean.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.rojean.bean.Order;

@Aspect
@Component
public class CacheAop {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Resource(name="redisTemplate")
	private ValueOperations<String,String> valueOps;
	
	@Pointcut("@annotation(com.rojean.aop.CacheAnnotation)")
	public void cacheData() {};
	
	
	@Around("cacheData()")
	public List<Order> roundCacheAop(ProceedingJoinPoint jp) {
		List<Order> lst = new ArrayList<Order>();
		try {
			System.out.println("CacheAop hello");
			String clazzName = jp.getTarget().getClass().getName();
			String methodName = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			
			String key = getKey(clazzName,methodName,args);
			System.out.println("Redis - Key:  " + key);
			
			String cacheData = valueOps.get(key);
			System.out.println("cacheData: " + cacheData);
			
			if("".equals(cacheData) || cacheData == null) {
				Object result = jp.proceed();
				
				lst = (List<Order>) result;
				String json = JSONObject.toJSONString(lst);
				valueOps.set(key, json);
				System.out.println("放入 Redis: OK" +json);
			}else {
				lst = JSONObject.parseObject(cacheData,lst.getClass());
				System.out.println("跳过Mysql 读取redis ! ");
			}
		} catch (Throwable e) {
			System.out.println(" CacheAop Exception: " + e + e.getMessage());
		}finally {
			return lst;
		}
	}
	
	private String getKey(String clazzName,String methodName,Object[] args) {
		StringBuffer s = new StringBuffer(clazzName).append("-");
		s.append(methodName).append("-").append(args[0]).append("-").append(args[1]);
		return s.toString();
	}
}
