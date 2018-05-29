package com.rojean.temp2;

import java.util.Random;

public class M {

	
	static class DaemonThread extends Thread{

		@Override
		public void run() {
			while(true) {
				System.out.println("000000000000000 - daemon");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public static void main(String[] args) {

		RojeanServiceImpl rojean = new RojeanServiceImpl();
		
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
			int v = rojean.readHandler();
			System.out.println("Read : " + v);
			}
		};
		
		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				int v =  new Random().nextInt();
				rojean.writeHandler(v);
				System.out.println("write: " + v);
			}
		};
		
		DaemonThread daemon  = new DaemonThread();
		daemon.setDaemon(true);
		daemon.start();
		
		
		for(int i=0;i<2;i++) {
			new Thread(readRunnable).start();
			new Thread(readRunnable).setPriority(1);
		}
		
		for(int i=0;i<2;i++) {
			new Thread(writeRunnable).start();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				rojean.hasNoLock();
			}
		}).start();
		
		
		
		try {
			Thread.sleep(2000);
			System.out.println("???????????????");
		} catch (InterruptedException e) {
		}
	}

}
