package com.stingray;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

public class Apps {

	private static Map<Integer, String> collect;
	//private static List<Integer> asList;

	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		List<Employee> eList = null;
		try {
			eList = EmployeeDao.getAllEmployee();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**
		 * Employee having salary greater than 200000 and Name start with some
		 * characters. A
		 */
		System.out.println(eList.stream().filter((e) -> e.getSalary() > 200000)
				.filter((e) -> e.getEmpName().startsWith("A")).collect(Collectors.toList()));
		/**
		 * Employee having salary joining date after 2017
		 */

		// eList.forEach(e-> System.out.println(e.getDjo().getYear()+1900));

		System.out.println(
				eList.stream().filter((e) -> (e.getDjo().getYear() + 1900) > 2017).collect(Collectors.toList()));

		// sort the list based upon employee name and salary using java 8
		/**
		 * if the name sorting is not equal then us the salary to sorting. ex:- if Two
		 * employee Name first character start with 'A' Anuj and Amit then use there
		 * salary for the search creteria. *
		 */
		System.out.println("**********************************001*******************************");
		System.out.println(eList);
		Collections.sort(eList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int compareResult = o1.getEmpName().compareTo(o2.getEmpName());
				if (compareResult == 0) {
					if (o1.getSalary() < o2.getSalary())
						compareResult = 1;
					else if (o1.getSalary() > o2.getSalary()) {
						compareResult = -1;
					} else {
						compareResult = 0;
					}
				}
				return compareResult;
			}
		});
		System.out.println(eList);
		
		covertListToMap(eList);
		
		sumOfArray();
		System.out.println("**********************************0004*******************************");

		checkFaltMapFunctionality(eList);
	}

	/**
	 * 
	 * @param eLsit
	 */
	private static void covertListToMap(List<Employee> eLsit) {
		collect = eLsit.stream().filter(e -> e.getEmpName().startsWith("T"))
				.collect(Collectors.toMap(Employee::getEmpId, Employee::getEmpName));
		
		collect.forEach((k,v)->System.out.println(k+" "+v));
	}
	/*8
	 * you have an integer array now find the sum of all the values using stream api
	 */
	
	private static void sumOfArray() {
		int arr[] = {1,2,3,4,5,6,7,8};
		List asList = Arrays.asList(arr);
		asList.forEach(System.out::println);
		
	}
	
	/**
	 * check the flatMap functinality
	 */
	private static void checkFaltMapFunctionality(List<Employee> eLsit) {
		
		/**
		 * first check the map working.
		 * 1) map is for the data extraction converting stream to a new stream. If we have the Employee stream we can use empid to get the 
		 * 
		 * a) On the basis of the grade need to find out the salary 
		 *    Find out the salary map of A grade employee and increase it to 1000
		 */
		eLsit.stream().filter((e)->e.getEmpGrade().equalsIgnoreCase("A")).map((e)->e.getSalary()+1000).collect(Collectors.toList()); 
		/**
		 * b) get email id of each employee 
		 */
		System.out.println("using map() ---> "+eLsit.stream().map((e)->e.getEmailIds()).collect(Collectors.toList()));
		
		List<String> collect3 = eLsit.stream().flatMap((e)->e.getEmailIds().stream()).collect(Collectors.toList());
		System.out.println("using flatMap() ---> "+collect3);

	}
	
}
