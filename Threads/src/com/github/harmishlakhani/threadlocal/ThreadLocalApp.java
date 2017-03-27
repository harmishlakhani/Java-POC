package com.github.harmishlakhani.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		SharedMap map = new SharedMap();
		
//		Thread A = new Thread(map);
//		Thread B = new Thread(map);
//		
//		A.start();
//		B.start();
//		
//		A.join();
//		B.join();
		
		for(int i = 0; i < 5; i++) {
			Thread thread = new Thread(map);
			thread.start();
			thread.join();
		}
		
		System.out.println(SharedMap.getThreadLocalMap().get());
	}
	
}

class SharedMap implements Runnable {
	
	private static final ThreadLocal<Map<String, Integer>> threadLocalMap = ThreadLocal.withInitial(() -> {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("abc", 2); 
		return map;
	});
	
//	public SharedMap() {
//		threadLocalMap = new ThreadLocal<Map<String, Integer>>();
//		threadLocalMap.set(new HashMap<String, Integer>());
//	}

	@Override
	public void run() {
//		if(threadLocalMap.get() == null ) {
//			threadLocalMap.set(new HashMap<String, Integer>());
//		}
		
//		if(threadLocalMap.get().containsKey(Thread.currentThread().getName())) {
//			threadLocalMap.get().put(Thread.currentThread().getName(), threadLocalMap.get().get(Thread.currentThread().getName()) + 1);
//		} else {
//			threadLocalMap.get().put(Thread.currentThread().getName(), 1);
//		}
		
		System.out.println(threadLocalMap.get());
		
		threadLocalMap.get().put("abc", 1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(threadLocalMap.get());
	}

	public static ThreadLocal<Map<String, Integer>> getThreadLocalMap() {
		return threadLocalMap;
	}
	
}