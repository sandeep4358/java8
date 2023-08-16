package com.stingray;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

public class TestMethodReferences2 {

	public static void main(String[] args) throws ParseException {

		List<Employee> allEmployee = EmployeeDao.getAllEmployee();
		
		Stream<Employee> stream = allEmployee.stream();
		
		List<Employee> test = stream.filter(e->e.getEmpName().startsWith("S")).collect(Collectors.toList());
	};
}
