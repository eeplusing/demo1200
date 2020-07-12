package com.eplusing.c6.deposit;

public class DeadLock implements Runnable{

	private boolean flag;
	private static final Object o1 = new Object();
	private static final Object o2 = new Object();
	public static void main(String[] args) {
		DeadLock dt1 = new DeadLock();
		DeadLock dt2 = new DeadLock();
		dt1.flag = true;
		dt2.flag = false;
		
		new Thread(dt1).start();
		new Thread(dt2).start();
		
	}
	
	

	@Override
	public void run() {
		if(flag == true){
			synchronized(o1){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程持有锁o1:" + Thread.currentThread().getName() + ":进入同步快o1");
				
				synchronized(o2){
					System.out.println("线程持有锁o2:" + Thread.currentThread().getName() + ":进入同步快o2");
				}
			}
		}else{
			synchronized(o2){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程持有锁o2:" + Thread.currentThread().getName() + ":进入同步快o2");
				
				synchronized(o1){
					System.out.println("线程持有锁o1:" + Thread.currentThread().getName() + ":进入同步快o1");
				}
			}
		}
	}

}
