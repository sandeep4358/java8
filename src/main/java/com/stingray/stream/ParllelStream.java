package com.stingray.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParllelStream {
    public static void main(String[] args) {
        long start=0;
        long end=0;
        System.out.println("=========================================Sequential stream=================================================================");

        start=System.currentTimeMillis();
        IntStream.range(1,100).forEach((t)-> {
            System.out.println(Thread.currentThread().getName() + " :: "+t);
        });
        end=System.currentTimeMillis();
        System.out.println("Plain stream took time : "+(end-start));

        System.out.println("===========================================Parllel Stream==========================================================================");

        start=System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach((t)-> {
                    System.out.println(Thread.currentThread().getName() + " :: "+t);
                }
        );
        end=System.currentTimeMillis();
        System.out.println("Parallel stream took time : "+(end-start));


    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
   static class Employee{
        String  empId;
        String name;
    }
}
