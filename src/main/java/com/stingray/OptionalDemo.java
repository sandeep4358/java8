package com.stingray;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class OptionalDemo {

	public static void main(String[] args) {
		try {
			checkOptional();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws ParseException
	 */
	static void checkOptional() throws ParseException {
		
		Customer customer = new Customer(1111, null);
		//Will create a optional empty object.
		System.out.println(Optional.empty());
		// of will create an container or can say teh object of the Optional wrap around the String.
		//Optional.of is used only there where there we no the value cannot be null, If it is null then
		//it will through the exception.
		
		/*Optional<String> name = Optional.of(customer.getName());
		System.out.println(name);
		*/
		///alternative of above is below, it will 
		
		System.out.println(Optional.ofNullable(customer.getName()));
		
		List<Customer> customerList = Arrays.asList(new Customer(11, null),new Customer(12, "ttttt"));
		String orElse = null;
		try {
			orElse = customerList.stream().map((c)->c.getName().toUpperCase()).findAny().orElseThrow(()->new Exception("testwt"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(orElse);
		
		
		

	}

}

@Data
@Getter
@Setter
@AllArgsConstructor
class Customer {
	int customerId;
	String Name;
}
