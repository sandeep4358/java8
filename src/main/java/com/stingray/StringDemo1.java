package com.stingray;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Compare two Strings in Java
 * 
 * @author sandeep.kumar
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		go() ;
	}
	
	
	/**
	 * now compare the two string without using equls method
	 */	
	static void go() {
		String string1 = "hello worlds I am sandeep";
		//check the first occranc of the h in the above String
		System.out.println( string1.indexOf("s"));  //index of fetch the first occurance 
		System.out.println( string1.indexOf("worlds"));  //index of fetch the first occurance 		
		System.out.println( string1.lastIndexOf("s"));  //last index of fetch the first occurance 		

		int length =  string1.length();
		for(int i=0;i<length;i++) {
			System.out.println(string1.charAt(i));
		}
	
		//we can also comapare the character using the arithmetic operation.
		/*String s1 = "hello";
		String s2 = "hello";
		int length; 
		if(s1.length()<s2.length())
			length = s2.length();
		else
			length =  s1.length();
		
		boolean flag = true;
		
		for (int i = 0; i < length; i++) {
			if(s1.charAt(i)<s2.charAt(i)) {
				flag= false;
			}else if(s1.charAt(i)>s2.charAt(i)) {
				flag= false;
			}
			if(!flag)
				break;
		}
		
		System.out.println("string are equals "+ flag);*/
		
	
	}
	
	
	/**
	 * difference between perm-generation and the heap area.
	 */
	void checkIntern() {
		String string1 = new String("Geeksforgeeks");
		//	   string1 = string1.intern();
		String string2 = new String("Practice");
		String string3 = new String("Geeks");
		String string4 = new String("Geeks");
		
		String string5 = "Geeksforgeeks";
		
		if(string1 == string5)
			System.out.println("equals");
		else
			System.out.println("not equals");
	
	}
	
	
	
	
	
	
	
}
