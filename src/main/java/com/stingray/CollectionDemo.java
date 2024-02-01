package com.stingray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CollectionDemo {

	public static void main(String[] args) throws Exception {
		
		int k = 1011 & 0111;
		System.out.println(k);
		
	}
	
	static void go() throws ParseException {

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
				System.out.println(optionalEmpName.orElseThrow(() -> new Exception("test")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * if(optionalEmpName.isPresent()) System.out.println(
			 * optionalEmpName.orElse("test"));
			 */

		});

	
	}

}

@Getter
@Setter
@AllArgsConstructor
class EmployeeKey {
	Integer id;
	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((id == null) ? 0 : id.hashCode()); return result;
	 * }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; EmployeeKey other = (EmployeeKey) obj; if (id == null) { if (other.id
	 * != null) return false; } else if (!id.equals(other.id)) return false; return
	 * true; }
	 * 
	 */

	@Override
	public boolean equals(Object obj) {
		EmployeeKey key = (EmployeeKey) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.getId(), key.getId());
		return builder.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(id);
		return builder.hashCode();
	}
}
