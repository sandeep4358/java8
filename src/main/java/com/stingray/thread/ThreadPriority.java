package com.stingray.thread;

public class ThreadPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread in execution : " + Thread.currentThread().getName() + " with priority : "
						+ Thread.currentThread().getPriority());
			}
		});

		Thread t2 = new Thread(() -> {
			System.out.println("Thread in execution : " + Thread.currentThread().getName() + " with priority : "
					+ Thread.currentThread().getPriority());
		});
		
		Thread t3 = new Thread(() -> {
			System.out.println("Thread in execution : " + Thread.currentThread().getName() + " with priority : "
					+ Thread.currentThread().getPriority());
		});
		Thread t4 = new Thread(() -> {
			System.out.println("Thread in execution : " + Thread.currentThread().getName() + " with priority : "
					+ Thread.currentThread().getPriority());
		});
		Thread t5 = new Thread(() -> {
			System.out.println("Thread in execution : " + Thread.currentThread().getName() + " with priority : "
					+ Thread.currentThread().getPriority());
		});

		t1.setPriority(4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
