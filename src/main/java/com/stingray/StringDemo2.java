package com.stingray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 
 * Remove Leading Zeros From String in Java
 * 
 * 	Input : 00000123569
	Output : 123569

	Input : 000012356090
	Output : 12356090
 */
public class StringDemo2 {
	static Logger log = LoggerFactory.getLogger(StringDemo2.class);

	public static void main(String[] args) {
		// go2();

		log.debug("String is palindrom :: " + checkTheInputStringIsPalidrom("SANDNAS"));
	}

	static void go2() {

		String input = "000001235069";
		StringBuilder s1 = new StringBuilder();
		boolean flag = true;
		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) != '0') {
				s1.append(input.charAt(i));
				flag = false;
			}
		}

		System.out.println(s1);

	}

	static void go() {
		Integer num1 = 100;
		Integer num2 = 100;
		Integer num3 = 500;
		Integer num4 = 500;

		if (num1 == num2) {
			System.out.println("num1 == num2");
		} else {
			System.out.println("num1 != num2");
		}
		if (num3 == num4) {
			System.out.println("num3 == num4");
		} else {
			System.out.println("num3 != num4");
		}
	}

	/**
	 * 
	 * @param string
	 */
	static boolean checkTheInputStringIsPalidrom(String string) {
		boolean flag = true;
		int j = string.length() - 1;

		for (int i = 0; i < string.length() / 2; i++) {
			//System.out.println("i = "+i+" "+"j = "+j+" "+string.charAt(i) + " : " + string.charAt(j));
			if (string.charAt(i) != string.charAt(j)) {
				flag = false;
				break;
			}
			--j;
		}
		return flag;
	}
}
