package com.eplusing.c6;

public class DaemonThreadTest {

	public static void main(String[] args) {
		Thread userThread = new Thread(new Worker());
		Thread daemonThread = new Thread(new Timer());
		daemonThread.setDaemon(true);
		userThread.start();
		daemonThread.start();
	}

}
