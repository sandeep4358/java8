package com.stingray.dataSoruce.thread;

/**
 * Let's say I have a number resource that will be increase to 10 then
 * only one by one thread access and modify it accordingly
 * 1. how to create a shared resource in thread?
 * 2. how to limit threads to access them one by one and only one thread access at one time.

  1. For the shared resource I can create a variable in the Main class and shared it with the thread at the time of
     when the thread is in the new start or create state.
        task:-For this I will use the implementation using normal thread creation + stream api.
 2.

 */
public class TreadTest {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread t1 = new Thread(new MyThread(resource));
        Thread t2 = new Thread(new MyThread(resource));

        t1.start();
        t2.start();
    }

}

class MyThread implements  Runnable{
    private Resource resource;
    MyThread(Resource resource){
        this.resource =  resource;
    }

    @Override
    public void run() {
        try {
            resource.increaseCount();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * Count resource . .
 */
class Resource {
    private Integer count = 0;

    public void increaseCount() throws InterruptedException {

            synchronized (this) {
                while (count < 10) {
                count = ++count;
                System.out.println(Thread.currentThread().getName() + " :: Number :: " + count);
               this.notify();
                this.wait();
            }
                this.notifyAll();

            }

    }
}
