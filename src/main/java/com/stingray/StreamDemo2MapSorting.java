package com.stingray;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

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
	
	static void sortEmployeeWithEmployeeNameStreamAPI() throws ParseException{
		List<Employee> allEmployee = EmployeeDao.getAllEmployee();		
		
		allEmployee.stream().sorted(Comparator.comparing(Employee::getEmpId)).forEach(System.out::println);;
	
		
		//how will i sort the employee on the basis of Employee name
		/*
		 * there are two way to sort the employee
		 */
		//1. implement comparable interface and assigned it to tree set.
		
	}

}
