package com.rojean.tread;

import java.util.concurrent.Callable;

public class CalcServiceImpl implements Runnable{

	private Order order;
	private double amount;
	private String threadName;
	
	public CalcServiceImpl() {
		
	}
	
	public CalcServiceImpl(String threadName,Order order,double amount) {
		this.threadName = threadName;
		this.order = order;
		this.amount = amount;
	}
	
	public void run() {
		calc(threadName,order,amount);
	}
	
	
	private void calc(String threadName,Order order,double v) {
		order.setAmount(threadName, v);
	}

	

}
