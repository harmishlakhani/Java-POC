package com.github.harmishlakhani.producerconsumer;

public class OddEvenProcessor {

	private boolean oddFlag = true;
	private Object lock = new Object();
	
	public void printOdd() throws InterruptedException {
		int value = 1;
		while(true) {
			synchronized (lock) {
				while(!oddFlag) {
					lock.wait();
				}
				System.out.println(Thread.currentThread().getName() + " => " + value);
				value = value + 2;
				oddFlag = false;
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
	
	public void printEven() throws InterruptedException {
		int value = 2;
		while(true) {
			synchronized (lock) {
				while(oddFlag) {
					lock.wait();
				}
				System.out.println(Thread.currentThread().getName() + " => " + value);
				value = value + 2;
				oddFlag = true;
				lock.notify();
			}
			Thread.sleep(1000);
		}
	}
}
