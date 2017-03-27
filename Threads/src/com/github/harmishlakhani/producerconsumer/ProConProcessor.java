package com.github.harmishlakhani.producerconsumer;

import java.util.LinkedList;

public class ProConProcessor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 20;
	private Object lock = new Object();
	
	public void producer() throws InterruptedException {
		int value = 0;
		while(true) {
			synchronized (lock) {
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		while(true) {
			synchronized (lock) {
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is : " + list.size());
				int value = list.removeFirst();
				System.out.println(" ;Value is : " + value);
				lock.notify();
			}
			Thread.sleep(1000);
		}
		
	}
}
