package com.stingray;

import java.security.cert.PKIXRevocationChecker.Option;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CollectionDemo {

	public static void main(String[] args) throws Exception {
		List<Employee> allEmployee = EmployeeDao.getAllEmployee();
		// Map<Integer, String> employeeMap =
		// allEmployee.stream().collect(Collectors.toMap(Employee::getEmpId,
		// Employee::getEmpName));

		Map<EmployeeKey, Employee> empMap = new HashMap<EmployeeKey, Employee>();
		EmployeeKey emp1 = new EmployeeKey(121);
		EmployeeKey emp2 = new EmployeeKey(121);

		empMap.put(emp1, new Employee(1111, "Shakshi", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("16/06/2018"),
				Arrays.asList(new String[] { "abc1@gmail.com", "abc2@gmail.com" }), "C"));
		empMap.put(emp2, allEmployee.get(2));

		empMap.put(null, new Employee());

		empMap.forEach((k, v) -> {
			Optional<String> optionalEmpName = Optional.ofNullable(v.getEmpName());
			
				try {
					System.out.println( optionalEmpName.orElseThrow(()->new Exception("test")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			/*if(optionalEmpName.isPresent())
				System.out.println( optionalEmpName.orElse("test"));*/
			
		});

	}

}

@Getter
@Setter
@AllArgsConstructor
class EmployeeKey {
	Integer id;

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

}
