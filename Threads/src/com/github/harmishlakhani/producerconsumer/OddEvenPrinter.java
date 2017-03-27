package com.github.harmishlakhani.producerconsumer;

public class OddEvenPrinter {

	public static void main(String[] args) throws InterruptedException {
		
		OddEvenProcessor processor = new OddEvenProcessor();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.printOdd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.printEven();
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
