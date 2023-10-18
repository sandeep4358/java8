package com.stingray.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestApp01 {

    /**
     *
     * @param args
     * We have the list of integer and findout the frequency of the Integers
     */
    static void getTheRangeFrequency(){
        List<Integer> integerList = Arrays.asList(10, 3, 5, 10, 3, 5, 10);

        Map map =  integerList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        map.entrySet().forEach(e-> System.out.println(e));
    }
    public static void main(String[] args) {



    }
}
