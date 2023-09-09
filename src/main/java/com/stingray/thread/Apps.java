package com.stingray.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apps {
	Logger log = LoggerFactory.getLogger(Apps.class);

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable);
		t1.start();
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		int i = 5;
		while (i > 0) {
			System.out.println("thread start()....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
		System.out.println("Thread Finished....");

	}
}