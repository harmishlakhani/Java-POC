package com.github.harmishlakhani.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private Account account1 = new Account();
	private Account account2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquireLock(Lock firstLock, Lock secondLock) throws InterruptedException {
		
		while(true) {
			boolean getFirstLock = false;
			boolean getSecondLock = false;
			
			try {
				getFirstLock = firstLock.tryLock();
				getSecondLock = firstLock.tryLock();
			} finally {
				if(getFirstLock && getSecondLock) {
					return;
				}
				if(getFirstLock) {
					firstLock.unlock();
				}
				if(getSecondLock) {
					secondLock.unlock();
				}
			}
			Thread.sleep(1);
		}
		
	}
	
	public void firstThread() throws InterruptedException {
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			acquireLock(lock1, lock2);
			try {
				Account.transfer(account1, account2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			acquireLock(lock2, lock1);
			try {
				Account.transfer(account2, account1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void finished() {
		System.out.println("Account1 Balance : " + account1.getBalance());
		System.out.println("Account2 Balance : " + account2.getBalance());
		System.out.println("Total Balance : " + (account1.getBalance() + account2.getBalance()));
	}
}
