package com.github.harmishlakhani.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	private AtomicInteger count = new AtomicInteger(0);
	
	public static void main(String[] args) {
		AtomicIntegerDemo synchronizedDemo = new AtomicIntegerDemo();
		synchronizedDemo.incrementCount();
	}
	
	public void incrementCount() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++)
					count.incrementAndGet();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++)
					count.incrementAndGet();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
}
