package com.stingray.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Sandeep Arya
 */
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service =      Executors.newFixedThreadPool(10);
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0 ; i<10 ; i++) {
            Future<String> future =  service.submit(new MyCallableTask());
            futureList.add(future);
        }

        for (Future<String> future :  futureList) {
            System.out.println("Thread with name : " +future.get());
        }
        service.shutdown();
    }

}


class MyCallableTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("in the call method of task :: " );
        return Thread.currentThread().getName() + " : "+new Date();
    }
}