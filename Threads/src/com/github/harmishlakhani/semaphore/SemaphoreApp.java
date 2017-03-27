package com.github.harmishlakhani.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreApp {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 200; i++) {
			service.submit(new Runnable() {
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
	}
}
