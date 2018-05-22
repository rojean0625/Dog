package com.rojean.serv;

import java.util.List;
import java.util.Map;

import com.rojean.bean.Order;

public interface OrderService {

	List<Order> findByMap(Map<String,String> queryMap);
}
