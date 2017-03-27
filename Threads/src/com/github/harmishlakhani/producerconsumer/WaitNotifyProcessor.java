package com.github.harmishlakhani.producerconsumer;

import java.util.Scanner;

public class WaitNotifyProcessor {

	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producing some items......");
			wait();
			System.out.println("Resumed.....");
		}
	}
	
	public void consumer() throws InterruptedException {
		Thread.sleep(2000);
		Scanner scanner = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Waiting for return key......");
			scanner.nextLine();
			System.out.println("Return key entered.......");
			notify();
			Thread.sleep(5000);
		}
	}
}
