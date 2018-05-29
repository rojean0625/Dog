package com.rojean.temp3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Drive {

	private int window;
	
	ReentrantLock lock = new ReentrantLock(false);
	
	public void go1() {
		try {
			lock.lockInterruptibly();
			System.out.println("Window: " + window);
		} catch (InterruptedException e) {
			System.out.println("我被监听线程 中断");
		}finally {
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
	
	public void go2() {
		lock.lock();
		window = window + 2;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
		}finally {
			lock.unlock();
		}
	}
	
	public void go3() {
		try {
			boolean r = lock.tryLock(3, TimeUnit.SECONDS);
			System.out.println("window "  + r + window);
		} catch (InterruptedException e) {
			System.out.println("我超时  中断");
		}finally {
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	
	
	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}
	
}
