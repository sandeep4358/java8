package com.stingray;

import lombok.ToString;
/**
 * 
 * @author sandeep.kumar
 * final variable must be assigned at the time of initilized. 
 */
public class ConstantAndVairableDemo {

	public static void main(String[] args) {
		Customers cust = new Customers();
		System.out.println("before :: " + cust);

		cust.customerID = 111;

		System.out.println("after :: " + cust);

	}
}

@ToString
class Customers {
	 int customerID = 10;
	 String customerName = "ravi";

}
