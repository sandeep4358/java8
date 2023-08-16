package com.stingray;

public class Test {

	public static void main(String[] args) {
		Resources mt = new Resources();
		Thread t1 = new Thread(mt::printOdd);
		t1.setName("t1");

		Thread t2 = new Thread(mt::printEven);
		t2.setName("t2");

		t1.start();
		t2.start();

	}

}

class Resources {
	int count = 1;
	int MAX = 20;

	public void printEven() {
		while (count <= MAX) {
			if (count % 2 != 0) {
				synchronized (this) {
					notify();
					count++;
					System.out.println(Thread.currentThread().getName() + " : " + count);
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

	public void printOdd() {
		while (count <= MAX) {
			if (count % 2 == 0)
				synchronized (this) {
					notify();
					count++;
					System.out.println(Thread.currentThread().getName() + " : " + count);
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}

	}
}
