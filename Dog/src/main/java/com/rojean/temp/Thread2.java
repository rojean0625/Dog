package com.rojean.temp;

import java.util.concurrent.Semaphore;

public class Thread2 implements Runnable {

	private LinjieQu linjieQu;
	//Semaphore semaphore = new Semaphore(2);

	public Thread2() {
	}

	public Thread2(LinjieQu bean) {
		this.linjieQu = bean;
	}

	@Override
	public void run() {
		try {
			//semaphore.acquire();

			System.out.println("TheadRuning2...");
			linjieQu.method3();
			System.out.println("TheadRuning2... complete");

			Thread.sleep(5000);
			//semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
