package com.rojean.bean;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

	private String code;
	private List<OrderInfo> orderInfos;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<OrderInfo> getOrderInfos() {
		return orderInfos;
	}
	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}
}
