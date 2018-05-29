package com.rojean.temp3;

public class Main {

	public static void main(String[] args) {
		
		Drive drive = new Drive();
		drive.setWindow(1);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				drive.go2();
			}
			
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				drive.go3();
				System.out.println("over");
			}
			
		});
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//t2.interrupt();
		
	}

}
