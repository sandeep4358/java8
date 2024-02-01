package com.stingray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.ToString;

class ImmutableDemo {
	public static void main(String[] args) {
		List<String> address1 = Arrays.asList("Mount view california","LosAngelus","NYC");
 		Student1 stud = new Student1(1, "sandeep", address1);
		System.out.println("Immutable :before: "+stud);
		
		List<String> addresses = stud.getAddresses();
		addresses =  Stream.of("New Delih","Kolkata","Mumbai").collect(Collectors.toList());
		
		System.out.println("Immutable :after: "+stud);
		//address1 = addresses;
		System.out.println("Immutable :after2: "+stud);

	}
}

@ToString
final class Student1 {
	private final int stu_id;
	private final String Stuname;
	private final List<String> addresses;

	public Student1(int stu_id, String stuname, List<String> address) {
		this.stu_id = stu_id;
		Stuname = stuname;
		//this.addresses = new ArrayList<String>(address);
		this.addresses = address;


	}

	public int getStu_id() {
		return stu_id;
	}

	public String getStuname() {
		return Stuname;
	}

	public List<String> getAddresses() {
		//return new ArrayList<String>(this.addresses);
		return this.addresses;

	}
	
	@Override
	public boolean equals(Object obj) {
		Student1 stu = (Student1) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(stu.stu_id, this.stu_id).isEquals();
		return super.equals(obj);
	}
}