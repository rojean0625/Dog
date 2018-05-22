package com.rojean.test;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.rojean.aop.DataBag;
import com.rojean.aop.IDo;
import com.rojean.bean.Order;
import com.rojean.serv.OrderService;

public class AopTest extends BaseTest{

	@Resource
	IDo doService;
	@Resource
	private OrderService orderService;
	
	@Test
	public void testAop1() {
		System.out.println("##### testAop1 #####");
		Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("agentNo", "881266");
		queryMap.put("productName", "pos");
		
		List<Order> order = orderService.findByMap(queryMap);
		
		System.out.println("## ·µ»Ø½á¹û: " + JSONObject.toJSONString(order));
	}
	
	public void testAop2() {
		System.out.println("##########");
		DataBag bag  = new DataBag();
		bag.setCustomerNo("customerNo123");
		bag.setAmt(new BigDecimal(0));
		doService.openFire(bag);
		
	}
}
