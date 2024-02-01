package com.stingray.reflecton;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestReflaction01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.stingray.reflecton.Emp");
        Method[] methods = aClass.getMethods();

        Stream<Method> stream = Arrays.stream(methods);
        stream.forEach((m)->{
            System.out.println(m.getName()+m.getParameterCount());
            Arrays.stream(m.getParameters()).sequential().forEach(System.out::println);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        });
    }
}
