package com.stingray.annotation;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Optional;

@interface MyAnnotation{
    String sayHello() default "hello world..";
}
class Hello {



    @MyAnnotation(sayHello = "This world is butiful.")
    public String testOfAnnotation(){

        return "called..";

    }
}


public class Exaple1 {
    public static void main(String[] args) {

        Hello h1 = new Hello();

        Method[] methods = h1.getClass().getMethods();
        Optional<Method> method = Arrays.stream(methods).peek((v)->{
            System.out.println(v.getName());
        }).filter((v) -> v.getName().equals("testOfAnnotation")).findFirst();
        Parameter[] parameters = method.get().getParameters();
        System.out.println(parameters.toString());

    }
}
