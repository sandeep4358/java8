package com.stingray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.ls.LSInput;

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

import ch.qos.logback.core.net.SyslogOutputStream;

public class StreamDemo2MapSorting {

	public static void main(String[] args) throws ParseException {
		sortingPractice28072021();
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
	static void sortingPractice28072021() throws ParseException {
		List<Employee> allEmployee = EmployeeDao.getAllEmployee();		
		ListIterator<Employee> iterator = allEmployee.listIterator();
		System.out.println("Before size :: "+allEmployee.size());
		Employee employee = null;
		Employee tempEmployee = null;

		/*while (iterator.hasNext()) {
			employee = iterator.next();
			if (employee.getEmpGrade().equals("B")) {
				iterator.remove();
				employee.setEmpGrade("D");
				iterator.add(employee);
			}

		}*/
	
		
		//Sorting the employee.
		Comparator<Employee> emp = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getEmpName().compareTo(o2.getEmpName());
			}
		};
		
		Collections.sort(allEmployee,emp);
		Function<Employee, List<String>> funtion = new Function<Employee, List<String>>() {
			
			@Override
			public List<String> apply(Employee t) {
				return t.getEmailIds();
			}
		}; 
		
		BinaryOperator<Double> binary = new BinaryOperator<Double>() {
			
			@Override
			public Double apply(Double t, Double u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		};
		
		System.out.println("-----------> "+allEmployee.stream().filter(e->e.getEmpGrade().equals("A")).map((e)->e.getSalary()).reduce(binary));
		
		ToIntFunction<Employee> e = new ToIntFunction<Employee>() {
			
			@Override
			public int applyAsInt(Employee value) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		Predicate<Employee> p = new Predicate<Employee>() {
			
			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		//find the average of the employee a salary with grade A
	System.out.println(""+allEmployee.stream().filter((t)->t.getEmpGrade().equals("A")).collect(Collectors.averagingDouble(Employee::getSalary)));
		
		//int total = employees.stream().collect(Collectors.averagingInt(Employee::getSalary));
		
		
	}
	
	
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
