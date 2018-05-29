package com.rojean.temp;

public class Thread1  implements Runnable {
	private LinjieQu  linjieQu ;
	ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	
	public Thread1() {}
	public Thread1(LinjieQu bean) {
		this.linjieQu = bean;
	}
	
	@Override
	public void run() {
		System.out.println("TheadRuning1..." + Thread.currentThread().getName());
		if(null == threadLocal.get()) {
			String v = "threadLocal 1" +System.currentTimeMillis();
			threadLocal.set(v);
			System.out.println("ThreadLocal set: " + v);
		}else {
			System.out.println("ThreadLocal get: " + threadLocal.get());
		}
		linjieQu.method2();
		System.out.println("TheadRuning1... complete");
		//threadLocal.remove();
	}
}
