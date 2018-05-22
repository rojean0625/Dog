package com.rojean.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.rojean.aop.CacheAnnotation;
import com.rojean.bean.Order;
import com.rojean.bean.OrderInfo;
import com.rojean.dao.OrderDao;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

	@CacheAnnotation
	@Override
	public List<Order> findByMap(String agentNo,String productName) {
		List<Order> result = new CopyOnWriteArrayList<Order>();
		
		Order order = new Order();
		order.setCode("ord-001");
		
		List<OrderInfo> infos = new CopyOnWriteArrayList<OrderInfo>();
		OrderInfo info = new OrderInfo();
		info.setName("成本模板01");
		info.setPrice(0.052);
		infos.add(info);
		
		order.setOrderInfos(infos);
		
		result.add(order);
		
		System.out.println("使用mysql 查询 orderDao");
		return result;
	}

}
