package com.github.harmishlakhani.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CDLProcessor implements Runnable {
	
	private CountDownLatch latch;
	
	public CDLProcessor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Starting work " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending work " + Thread.currentThread().getName());
		latch.countDown();
	}
}

public class CountDownLatchApp {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 10; i++) {
			executorService.submit(new CDLProcessor(latch));
		}
		
		System.out.println("All task submitted");
		
		executorService.shutdown();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed successfully");
	}
}
