package com.stingray.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestApp {
    public static void main(String[] args) {
        Map<Employee,Integer> employeeMap =  new HashMap<>();
        employeeMap.put(new Employee(12,"AAA"), 101);
        employeeMap.put(new Employee(12,"AAA"), 102);
        employeeMap.put(new Employee(12,"AAA"), 103);
        employeeMap.put(new Employee(12,"AAA"), 104);
        employeeMap.put(new Employee(12,"AAA"), 105);

        employeeMap.entrySet().stream().forEach(e-> System.out.println("[" +e.getKey()+"] :: ["+e.getValue()+"]"));


    }
}



class Employee{
    int id;
    String name;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Employee emp1 = (Employee) obj;
        return this.getName()==((Employee) obj).getName();
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    Employee(){

    }

    Employee(int id,String name){
        this.id = id;
        this.name = name;

    }
}