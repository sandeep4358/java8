import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student s1 = new Student(111, "Sandeep");
		Student s2 = (Student) s1.clone();

		Stream.of(s1, s2).forEach(System.out::println);
	}
}

@Data
@AllArgsConstructor
class Student implements Cloneable {
	int stu_id;
	String stuName;

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}