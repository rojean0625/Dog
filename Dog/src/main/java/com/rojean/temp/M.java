package com.rojean.temp;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class M {

	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static Lock readLock = rwl.readLock();
	static Lock writeLock = rwl.writeLock();
	int value;
	
	public int handRead(Lock lock) {
		try {
			lock.lock();
			System.out.println("¶Á lock");
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}finally {
			lock.unlock();
		}
		return value;
	}
	
	
	public void writeHandler(Lock lock,int v) {
		try {
			lock.lock();
			System.out.println("Ð´ lock");
			Thread.sleep(1000);
			value = v;
		} catch (Exception e) {

		}finally {
			lock.unlock();
		}
	}

	
	public static void main(String[] args) {
		ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
		M m = new M();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
			int v = m.handRead(readLock);
			System.out.println("Read : " + v);
			}
		};
		
		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				int v =  new Random().nextInt();
				m.writeHandler(writeLock,v);
				System.out.println("write: " + v);
			}
		};
		
		
		
		for(int i=0;i<18;i++) {
			new Thread(readRunnable).start();
		}
		
		for(int i=0;i<2;i++) {
			new Thread(writeRunnable).start();
		}
	}

}
