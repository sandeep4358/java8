package com.stingray.desinePattern.builderPattern;


/**
 * Builder desine  pattern
 */
public class BuilderTest {
    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder().setName("Sheldon").setEmp_id(01232).build();
        System.out.println(employee);
    }
}


class Employee{
    final private  int emp_id;
    final private  String name;
    final private  double salary;


    Employee(EmployeeBuilder builder){
        emp_id = builder.emp_id;
        name = builder.name;
        salary = builder.salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    static class EmployeeBuilder{
        private  int emp_id;
        private  String name;
        private  double salary;

        public  EmployeeBuilder setEmp_id(int emp_id) {
            this.emp_id = emp_id;
            return  this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }


    }


}