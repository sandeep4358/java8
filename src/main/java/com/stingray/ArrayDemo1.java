package com.stingray;

import java.util.Arrays;

public class ArrayDemo1 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		go();
	}
	
	/**
	 * 
	 */
	static void go() {
		Integer[] a = new Integer[]{45, 12, 78, 34, 89, 21};
        System.out.println(a);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
	}
}
