package com.rojean.tread;

public class Order {

	private double amount;
	
	public synchronized  void setAmount(String threadName,double amount) {
			this.amount = amount;
			System.out.println(threadName + "  set  " + amount);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public double getAmount() {
		return amount;
	}
}
