package com.rojean.temp2;

public class RojeanServiceImpl {

	
	int value;
	
	
	
	public void hasNoLock() {
		System.out.println("guaguagua");
	}
	
	public int readHandler() {
		synchronized(this) {
			try {
				System.out.println("�� ��ʼ����");
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}
	}
	
	public void writeHandler(int v) {
		synchronized (this) {
			try {
				System.out.println("д  ��ʼ����");
				value = v;
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
		
}
