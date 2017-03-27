package com.github.harmishlakhani.producerconsumer;

public class WaitNotifyApp {

	public static void main(String[] args) throws InterruptedException {
		
		WaitNotifyProcessor processor = new WaitNotifyProcessor();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
