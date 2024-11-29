package com.learning.ay.multithreading;

public class ExecuteThreadOneAfterAnother {
    public static void main(String[] args){
        final Thread t1 = new Thread(()->{
            System.out.println("Starting Thread 1");
            System.out.println("Ending Thread 1");

        });
        final Thread t2 = new Thread(()->{
            System.out.println("Starting Thread 2");
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ending Thread 2");
        });
       final Thread t3 = new Thread(()->{
            System.out.println("Starting Thread 3");
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ending Thread 3");
        });
        t3.start();
        t2.start();
        t1.start();
        t1.start();


    }
}
