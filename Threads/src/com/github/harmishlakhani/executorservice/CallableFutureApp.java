package com.github.harmishlakhani.executorservice;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureApp {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Future<Integer> future = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				Random random = new Random();
				int sleepTime = random.nextInt(4000);
				
				System.out.println("Starting.....");
				
				Thread.sleep(sleepTime);
				
				System.out.println("Ending.....");
				
				return sleepTime;
			}
			
		});
		
		executorService.shutdown();
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
