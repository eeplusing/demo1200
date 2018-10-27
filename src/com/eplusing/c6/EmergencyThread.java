package com.eplusing.c6;

public class EmergencyThread implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 6; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("紧急情况：" + i + "号车出发");
		}
	}

}
