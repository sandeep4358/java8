package com.stingray.stream;

import com.stingray.dataSoruce.Employee;
import com.stingray.dataSoruce.EmployeeDao;

import java.text.ParseException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sandeep.kumar
 */
public class Java8_001 {
    /**
     * 21. Sort Employee on the basis of there age.
     */
    public static void getEmployeeDetails() {
        try {
            List<Employee> employeeList = EmployeeDao.getAllEmployee();

            Optional<Employee> employee =  employeeList.stream().filter(e->e.getEmpName().startsWith("A")).findAny();

            if(employee.isPresent()){
                System.out.println( employee.get());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        getTheEmployeeNameWithLongestString();


    }

    public static void createMapFromEmployeelist(){
        Map<Integer,String> mapstring =  EmployeeDao.getAllEmployee().stream().collect(Collectors.toMap(Employee::getEmpId,Employee::getEmpName));
        mapstring.forEach((integer, s) -> {System.out.println("key :: "+integer+ " value :: "+s );});
    }

    public static void getTheEmployeeNameWithLongestString(){
        Optional<String> empOptional =  EmployeeDao.getAllEmployee().stream().map(Employee::getEmpName).reduce((e1,e2)->e1.length()>e2.length()?e1:e2);
        if(empOptional.isPresent()){
            System.out.println( empOptional.get());
        }

    }

    /**
     * Flatting of EmployeeList using the employee list.
     */
    public static void flattringOfEmployeeList(){
        List<String> list = EmployeeDao.getAllEmployee().stream().flatMap((e)->e.getEmailIds().stream()).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * Sort the Employee list using the employee name.
      */
    public void sortingEmployeeList(){
        List<Employee> employeeList = EmployeeDao.getAllEmployee();
        employeeList.stream().sorted(
                (e1,e2)->
                {return e1.getEmpName().compareTo(e2.getEmpName());}).collect(Collectors.toList()).stream().forEach(System.out::println);

    }

    /**
     * 22. What is the code to sort strings using the Java 8 lambda expression?
     */
    public static void sortAString() {
        List<String> names = Stream.of("Red", "Orange", "Blue", "Yellow").collect(Collectors.toList());
        names.forEach((e) -> System.out.println(e));
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("-------after---------");
        names.forEach(System.out::println);
        //TestStatic.check2();
    }

    /**
     * 23. Is it possible to call a static method of any interface in a class using
     * Java 8?
     */

    static void randomUse() {
        Random random = new Random();
        random.ints().limit(20).forEach(System.out::println);

    }

    /**
     * 26. What is the easiest way to print the sum of all of the numbers present in a list using Java 8?
     */
    static void printSum() {
        List<Integer> integerList = Stream.of(12, 45, 10, 47, 34).collect(Collectors.toList());
        System.out.println(integerList);

        Optional<Integer> integerOptional = integerList.stream().reduce((a, b) -> a + b);
        if (integerOptional.isPresent())
            System.out.println(integerOptional.get());
    }
}

