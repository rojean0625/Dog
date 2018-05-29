package com.rojean.nio.client;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		new Thread(new Runnable() {
			@Override
			public void run() {
				ServiceHandler service = new ServiceHandler();
				try {
					service.doListenling();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		Thread.sleep(2000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				ClientHandler client = new ClientHandler();
				try {
					client.doRequest();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
