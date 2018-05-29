package com.rojean.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class LinjieQu {

	public synchronized void method1() {
		System.out.println("Methon1 begin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method2() {
		System.out.println("public void method2()");
		synchronized (this) {
			System.out.println("Method2 begin");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	Semaphore semaphore = new Semaphore(2);
	public void method3() {
		try {
			semaphore.acquire();
			System.out.println("Method3 begin");
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
