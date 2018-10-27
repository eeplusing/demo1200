package com.eplusing.c6.deposit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	public static ThreadLocal<Integer> account = new ThreadLocal<Integer>(){
		protected Integer initialValue(){
			return 100;
		}
	};
	//private volatile int account = 100;
	/*public void deposit(int money){
		synchronized(this){
			account += money;
			System.out.println("账户的余额是：" + getAccount());
		}
	}*/
	
	private Lock lock = new ReentrantLock();
	
	public void deposit(int money){
		account.set(account.get() + money);;
		System.out.println("账户的余额是：" + getAccount());
	}
	
	public int getAccount(){
		return account.get();
	}
}

/*public class Bank {
	private int account = 100;
	//private volatile int account = 100;
	public void deposit(int money){
		synchronized(this){
			account += money;
			System.out.println("账户的余额是：" + getAccount());
		}
	}
	
	private Lock lock = new ReentrantLock();
	
	public void deposit(int money){
		lock.lock();
		try {
			account += money;
			System.out.println("账户的余额是：" + getAccount());
		} finally{
			lock.unlock();
		}
	}
	
	public int getAccount(){
		return account;
	}
}*/
