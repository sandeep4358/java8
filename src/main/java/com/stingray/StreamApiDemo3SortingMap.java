package com.stingray;

import java.text.ParseException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

public class StreamApiDemo3SortingMap {
	static Map<Employee, Integer> map = null;
	public static void main(String[] args) throws ParseException {
		 map = EmployeeDao.getAllEmployeeMap(new HashMap<Employee, Integer>());
		go();
	}
	
	static void go() throws ParseException {
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("sdfds", 12);
		map1.put("ererr", 22);
		map1.put("aoioo", 1);
		
		/*
		 * List<Entry<String, Integer>> list = new
		 * ArrayList<Map.Entry<String,Integer>>(map1.entrySet()); Collections.sort(list,
		 * (e1,e2)->e1.getKey().compareTo(e2.getKey()));
		 * list.stream().forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
		 */
		
		map1.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		map1.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		Map<Employee, Integer> allEmployeeMap = EmployeeDao.getAllEmployeeMap(new HashMap<>());
		
		allEmployeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName).reversed())).forEach(e->System.out.println(e.getKey()+" :: "+e.getValue()));;

		
		
		
//map1.entrySet().stream().sorted().forEach(e->System.out.println(e.getValue()+" "+e.getKey()));
		
		
		
		
	
	}
}
