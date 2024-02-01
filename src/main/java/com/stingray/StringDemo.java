package com.stingray;

/*
Input: a = "Hello"
b = "World"

Output:
Strings before swap: a = Hello and b = World
Strings after swap: a = World and b = Hello
*/
public class StringDemo {
	public static void main(String[] args) {}
/**
 * 
 * Swap two Strings without using third user defined variable in Java
 * 
 */
	
	void withoutUsingThirdVariable() {

		String a ="Hello";
		String b = "World";
		System.out.println("a ---"+a);
		System.out.println("b ---"+b);

		a=a+b;
		b=(String) a.substring(0, a.length()-b.length());
	
		a=a.substring(a.length()-b.length(), a.length());
		System.out.println("a ---"+a);
		System.out.println("b ---"+b);

	
	}
}
