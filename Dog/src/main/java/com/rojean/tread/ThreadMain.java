package com.rojean.tread;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ThreadMain {

	public static void main(String[] args) {
		
		ExecutorService threadService  = Executors.newFixedThreadPool(10);
		Order order = new Order();
	    
		System.out.println("begin..");
		threadService.execute(new CalcServiceImpl("Thread-01",order,100));
		threadService.execute(new CalcServiceImpl("Thread-02",order,200));
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(order.getAmount());
	    
		int i = 1;
		System.out.println(i++);
		System.out.println(i);
		
		Map m = new HashMap();
		m.put("", "");
	}
}
