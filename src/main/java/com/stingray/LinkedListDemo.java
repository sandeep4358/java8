package com.stingray;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LinkedListDemo {
	public static void main(String[] args) {
		Order order4 = new Order(1114, "Solimo BedSheet");
		Order order1 = new Order(1111, "Zentex Mobile 5v charger");
		Order order2 = new Order(1112, "Philips Trimmer");
		Order order3 = new Order(1113, "Nikon DSLR");
		
		Stream<Order> stream = Stream.of(order1,order2,order3,order4);
		
		
		
		LinkedList<Order> orderList = new LinkedList<Order>(stream.collect(Collectors.toList()));

		System.out.println( orderList.get(2));
		 	
		
		
	}	
}

@Data
@AllArgsConstructor
class Order{
	int orderId;
	String description;
}
