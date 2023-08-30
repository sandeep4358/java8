package com.stingray.interviewProgram;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

/**
 * Let say we are creating an LRU cache for the pages user select
 * User sequence for the page selection would be
 * 1,2,3,4,5,7,2,4,8,9,2,2
 * queue capacity will be 5
 */
public class LRUCacheImplementaion {

    private Deque<Integer> queue =  new LinkedList<Integer>();
    int MAX_CAPACITY = 4;

    public void putValueInQueue(Integer key){

        if(queue.contains(key)){
            System.out.println("if key already present :: "+key);
            queue.remove(key);
            queue.addFirst(key);
        }else {
            System.out.println("queue Size :: "+queue.size());
            if(queue.size()==MAX_CAPACITY){
                System.out.println("remove last element");
                queue.remove(key);
            }

            queue.addFirst(key);
        }

    }

    public void printCacheElements(){
        queue.forEach(System.out::println);
    }

    public static void main(String[] args) {

        LRUCacheImplementaion cache = new LRUCacheImplementaion();
        cache.putValueInQueue(1);
        cache.putValueInQueue(2);
        cache.putValueInQueue(3);
        cache.putValueInQueue(4);
        cache.putValueInQueue(5);
        cache.putValueInQueue(7);
        cache.putValueInQueue(6);

        cache.printCacheElements();
    }

}
