package com.github.harmishlakhani.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class HclProcessor implements Runnable {
	
	private int id;
	
	public HclProcessor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting work : " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending work : " + id);
	}
}

public class ThreadPoolApp {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 5; i++) {
			executorService.submit(new HclProcessor(i));
		}
		
		System.out.println("All task submitted");
		
		executorService.shutdown();
		
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed successfully");
	}
}
