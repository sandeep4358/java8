package com.stingray.reflecton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("com.stingray.reflecton.Emp");
            //Iterable

        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        Stream<Constructor<?>> stream = Arrays.stream(declaredConstructors);
        stream.forEach((ccon) ->{
            System.out.println("Constructor details :: "+ccon.getName());
            System.out.println("Constructor parameter count :: "+ccon.getParameterCount());
            Parameter[] parameters = ccon.getParameters();
            Stream<Parameter> stream1 = Arrays.stream(parameters);
            stream1.forEach((para)->{
                System.out.println(" Parameter :: "+para.getName()+" of type :: "+para.getType());
            });
        });

        System.out.println("================Method information =====================================");

        Method[] declaredMethods = c.getDeclaredMethods();
        Stream<Method> stream1 = Arrays.stream(declaredMethods);
        stream1.forEach((method -> {
            System.out.println("Method Details :: "+method.getName()+ " :: parameter count :: "+method.getParameterCount());

            Parameter[] parameters = method.getParameters();
            Stream<Parameter> stream2 = Arrays.stream(parameters);
            stream2.forEach(parameter -> {
                System.out.println("Parameter "+parameter.getName() + " type :: "+parameter.getType());
            });
        }));

    }
}
