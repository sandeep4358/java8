package com.stingray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

public class CollectionDemo09012021 {
	public static void main(String[] args) throws ParseException {
		Map<Employee, Integer> employeeMap = EmployeeDao.getAllEmployeeMap(new HashMap<Employee, Integer>());

		Thread t1 = new Thread(new Mythread(employeeMap), "t1");
		t1.start();

		
		  Thread t2 = new Thread(new Mythread2(employeeMap), "t2"); t2.start();
		 

	}
}

class Mythread implements Runnable {
	Map<Employee, Integer> map;

	public Mythread(Map<Employee, Integer> map) {
		this.map = map;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " run method executed");		
	
		Set<Employee> keySet = map.keySet();
		keySet.stream().map(e->map.get(e)).forEach(System.out::println);		
		/*
		 * Set<Entry<Employee, Integer>> entrySet = map.entrySet();
		 * 
		 * Iterator<Entry<Employee, Integer>> iterator = entrySet.iterator(); while
		 * (iterator.hasNext()) { Entry<Employee, Integer> entry = iterator.next();
		 * System.out.println(Thread.currentThread().getName() + " :: " + entry.getKey()
		 * + " :: " + entry.getValue()); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 * 
		 * }
		 */

	}
}

class Mythread2 implements Runnable {
	Map<Employee, Integer> map;

	public Mythread2(Map<Employee, Integer> map) {
		this.map = map;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " run method executed");
		Employee e9 = null;
		try {
			e9 = new Employee(1119, "Anamika", 150000, new SimpleDateFormat("dd/MM/yyyy").parse("16/01/2016"),
					Arrays.asList(new String[] { "abc1@gmail.com", "abc2@gmail.com" }), "A");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put(e9, 110);

	}
}