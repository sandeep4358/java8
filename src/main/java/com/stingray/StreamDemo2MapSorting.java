package com.stingray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

import ch.qos.logback.core.net.SyslogOutputStream;

public class StreamDemo2MapSorting {

	public static void main(String[] args) throws ParseException {
		sortEmployeeWithEmployeeName();
	}

	static void sortEmployeeWithEmployeeName() throws ParseException {
		List<Employee> allEmployee = EmployeeDao.getAllEmployee();		
		
		Set<Employee> set = new TreeSet<Employee>((o1,o2)->(int) (o1.getSalary()-o2.getSalary()));
		set.addAll(allEmployee);
		System.out.println(set.size());
		set.forEach(System.out::println);
		
		//how will i sort the employee on the basis of Employee name
		/*
		 * there are two way to sort the employee
		 */
		//1. implement comparable interface and assigned it to tree set.
		
	}
	
	//Sorting an employee on the basis of employee name
	//Find out all the grade a employee and find there average salary.
	
	
	
	static void sortEmployeeWithEmployeeNameStreamAPI() throws ParseException{
		List<Employee> allEmployee = EmployeeDao.getAllEmployee();		
		
		allEmployee.stream().sorted(Comparator.comparing(Employee::getEmpId)).forEach(System.out::println);;
	
		
		//how will i sort the employee on the basis of Employee name
		/*;
		 * there are two way to sort the employee
		 */
		//1. implement comparable interface and assigned it to tree set.
		
	}
	
	static void sortEmployeeMapUsingStreamAPI() throws ParseException {
		Map<Employee, Integer> employeeMap = EmployeeDao.getAllEmployeeMap(new HashMap<Employee, Integer>());

		Set<Entry<Employee, Integer>> entrySet = employeeMap.entrySet();
		ArrayList<Entry<Employee, Integer>> arrayList = new ArrayList<Entry<Employee, Integer>>(entrySet);
		
		Collections.sort(arrayList, new Comparator<Entry<Employee, Integer>>() {
			@Override
			public int compare(Entry<Employee, Integer> o1, Entry<Employee, Integer> o2) {
				return (int) (o1.getKey().getSalary() - o2.getKey().getSalary());
			}
		});
		
		arrayList.stream().forEach(e->e.getKey());
		
		

	}
	

}
