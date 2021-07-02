package com.stingray;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author sandeep.kumar
 * 
 */
public class Java8_001 {

	public static void main(String[] args) {
		printSum();
	}

	/**
	 * 22. What is the code to sort strings using the Java 8 lambda expression?
	 * 
	 */
	public static void sortAString() {
		List<String> names = Stream.of("Red", "Orange", "Blue", "Yellow").collect(Collectors.toList());
		names.forEach((e) -> System.out.println(e));
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println("-------after---------");
		names.forEach(System.out::println);
		//TestStatic.check2();
	}
	/**
	 * 23. Is it possible to call a static method of any interface in a class using
	 * Java 8?
	 */
	
	 static void randomUse() {
		Random random = new Random();
		random.ints().limit(20).forEach(System.out::println);

	}

	/**
	 * 26. What is the easiest way to print the sum of all of the numbers present in a list using Java 8?
	 */
	 static void printSum() {
		 List<Integer> integerList = Stream.of(12,45,10,47,34).collect(Collectors.toList());
		 System.out.println(integerList);
		 
		 Optional<Integer> integerOptional = integerList.stream().reduce((a,b)->a+b);
		 if(integerOptional.isPresent())
			 System.out.println( integerOptional.get());
	 }
}

