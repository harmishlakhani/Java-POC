package com.github.harmishlakhani.basic;

import java.util.Scanner;

class MyProcessor extends Thread {
	private volatile boolean shutdown = true;

	public void run() {
		while (shutdown) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		shutdown = false;
	}
}

public class VolatileDemo {

	public static void main(String[] args) {
		MyProcessor processor1 = new MyProcessor();
		processor1.start();
		
		MyProcessor processor2 = new MyProcessor();
		processor2.start();
		
		System.out.println("Hit enter to shutdown");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		processor1.shutdown();
		processor2.shutdown();
	}
}
