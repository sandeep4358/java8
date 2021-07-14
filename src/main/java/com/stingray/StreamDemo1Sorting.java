package com.stingray;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * 
 * PSC  :- predicate, supplier, consumer
 */

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

public class StreamDemo1Sorting {
static	List<Employee> allEmployee = null;	

	public static void main(String[] args) throws ParseException {
		allEmployee = EmployeeDao.getAllEmployee();
		/*1) Print all the employee name that are start with the "S"		
		allEmployee.stream().filter(t->t.getEmpName().startsWith("S")).forEach( t->  System.out.println(t));
		*/
		
		
		/*
		  2) if we want to sort the list with primitive value then below is the steps
		 
		 
		List<Integer> asList = Arrays.asList(1,34,2,6,13,25);
		asList.stream().sorted().forEach((i)->System.out.println(i));
		asList.stream().sorted().forEach(System.out::println);
		//reverse sorting using the Stream API.
		//asList.stream(). .forEach(System.out::println);
		*/

		//Now Employee Sorting Custom object sorting.
		
		/*Collections.sort(allEmployee,new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getEmpName().compareTo(o2.getEmpName());
			}
		});*/		
		
	//	Collections.sort(allEmployee,(o1,  o2)-> o1.getEmpName().compareTo(o2.getEmpName()));
		
		
		//allEmployee.stream().sorted((o1,  o2)-> o1.getEmpName().compareTo(o2.getEmpName())).forEach(System.out::println);
		
		//allEmployee.stream().sorted(Comparator.comparing()).forEach(System.out::println);

		
		///allEmployee.forEach(System.out::println);
		
		/**
		 * Sorting Employee with the employee name
		 */
		mapShorting();
	}
	
	/**
	 * Sorting list using the Stream API
	 */
	static void usingStreamApiToSortList() {
		Comparator<Employee> comparator = Comparator.comparing(Employee::getEmpName);
		Collections.sort(allEmployee,comparator);
		//allEmployee.stream().forEach(e->System.out.println(e));
		
		allEmployee.stream().sorted(Comparator.comparing(Employee::getEmpName)).forEach(e->System.out.println(e));
	}

	/***
	 * 
	 * @throws ParseException
	 */
	static void mapShorting() throws ParseException {		
	Map<Employee, Integer> allEmployeeMap = (HashMap<Employee, Integer>) EmployeeDao.getAllEmployeeMap(new TreeMap<Employee,Integer>());

	allEmployeeMap.forEach((k,v)->k.getEmpName());
	
	
	}
	
}
