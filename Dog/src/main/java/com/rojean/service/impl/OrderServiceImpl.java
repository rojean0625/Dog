package com.rojean.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rojean.bean.Order;
import com.rojean.dao.OrderDao;
import com.rojean.serv.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;
	
	@Override
	public List<Order> findByMap(Map<String, String> queryMap) {
		return orderDao.findByMap(queryMap.get("agentNo"),queryMap.get("productName"));
	}

}
