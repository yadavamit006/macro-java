package com.learning.ay.multithreading;

public class InterruptedExample {
    public static void main(String[] args){
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) {//When we call interrupted(), the flag is returned True/False and immediately set to false.
                    System.out.println("Thread Interrupted");
                    break;
                }
                for (int i = 1; i <= 2; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    System.out.println("Hello " + i);
                }
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("Interrupted Status : "+ thread.interrupted());
        //Thread.currentThread().wait();//Exception : java.lang.IllegalMonitorStateException
        //Thrown to indicate that a thread has attempted to wait on an object's monitor or to notify other threads waiting on an object's monitor without owning the specified monitor.
    }
}
