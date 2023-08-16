package com.stingray;

import java.util.HashMap;
import java.util.Map;

public class ThreadTest {
	public static void main(String[] args) {

		Resource r1 = new Resource();

		Thread t1 = new Thread(new Work(r1));
		t1.setName("t1");
		t1.start();
		Thread t2 = new Thread(new Work(r1));
		t2.setName("t2");
		t2.start();

	}
}

class Work implements Runnable {

	Resource r1 = null;

	public Work(Resource r1) {
		this.r1 = r1;
	}

	@Override
	public void run() {

		try {
			r1.count();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + r1.count);

	}
}

class Resource {

	int count;

	String lastThread = "t1";

	Map<String, String> map = new HashMap<String, String>();

	public Resource() {
		map.put("t1", "t2");
		map.put("t2", "t1");
//		 map.put("t1", "t2");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void count() throws InterruptedException {
		while (count < 11) {
			synchronized (this) {
				if (lastThread.equals("t1")) {
					count = count++;
					lastThread = map.get("t1");
				} else {
					count = count++;
					lastThread = map.get("t1");
				}
				this.notify();
				this.wait();
			}

		}
		
		

	}

}