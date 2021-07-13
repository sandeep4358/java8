package com.stingray.dataSoruce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EmployeeDao {

	public static List<Employee> getAllEmployee() throws ParseException {
		List<Employee> emplist = new ArrayList<Employee>();
		Employee e1 = new Employee(1111, "Shakshi", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("16/06/2018"),
				Arrays.asList(new String[] { "abc1@gmail.com", "abc2@gmail.com" }), "C");
		Employee e2 = new Employee(1112, "Tarun", 300000, new SimpleDateFormat("dd/MM/yyyy").parse("17/03/2019"),
				Arrays.asList(new String[] { "abc3@gmail.com", "abc4@gmail.com" }), "B");
		Employee e3 = new Employee(1113, "Prakasha", 400000, new SimpleDateFormat("dd/MM/yyyy").parse("16/06/2020"),
				Arrays.asList(new String[] { "Prakasha1@gmail.com", "Prakasha6@gmail.com" }), "A");
		Employee e4 = new Employee(1114, "Sanju", 600000, new SimpleDateFormat("dd/MM/yyyy").parse("16/07/2011"),
				Arrays.asList(new String[] { "Sanju3@gmail.com", "Sanju4@gmail.com" }), "A");
		Employee e5 = new Employee(1115, "Kashi", 100000, new SimpleDateFormat("dd/MM/yyyy").parse("16/04/2016"),
				Arrays.asList(new String[] { "Kashi@gmail.com", "Kashi554@gmail.com" }), "C");
		Employee e6 = new Employee(1116, "Ram", 150000, new SimpleDateFormat("dd/MM/yyyy").parse("16/06/2018"),
				Arrays.asList(new String[] { "aRam@gmail.com", "abc2@gmail.com" }), "C");
		Employee e7 = new Employee(1117, "Anjali", 450000, new SimpleDateFormat("dd/MM/yyyy").parse("16/03/2019"),
				Arrays.asList(new String[] { "Anjali@gmail.com", "abc2@gmail.com" }), "B");
		Employee e8 = new Employee(1118, "Anamika", 550000, new SimpleDateFormat("dd/MM/yyyy").parse("16/01/2016"),
				Arrays.asList(new String[] { "abc1@gmail.com", "abc2@gmail.com" }), "A");
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		emplist.add(e4);
		emplist.add(e5);
		emplist.add(e6);
		emplist.add(e7);
		emplist.add(e8);
		return emplist;
	}

	/**
	 * 
	 * @param implementaion of the Map whether it is TreeMap,HashMap,LinkedHashMap
	 * @return
	 * @throws ParseException
	 */
	public static Map<Employee, Integer> getAllEmployeeMap(Map<Employee, Integer> empMap) throws ParseException {

		Optional<Map<Employee, Integer>> optionalMap = Optional.ofNullable(empMap);
		if (optionalMap.isPresent()) {

			int i = 0;
			empMap = optionalMap.get();
			for (Employee emp : getAllEmployee()) {
				i++;
				empMap.put(emp, new Integer(i));
			}
		}
		return empMap;
	}
}
