package com.rojean.dao;

import java.util.List;
import java.util.Map;

import com.rojean.bean.Order;

public interface OrderDao {

	List<Order> findByMap(String agentNo,String productName);
}
