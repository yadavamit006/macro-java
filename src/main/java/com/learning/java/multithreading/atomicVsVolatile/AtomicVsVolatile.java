package com.learning.java.multithreading.atomicVsVolatile;

import org.springframework.aop.ThrowsAdvice;

import java.util.concurrent.atomic.AtomicInteger;
//https://www.baeldung.com/java-volatile-vs-atomic

class Task extends Thread {

    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private volatile int volatileCount;

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            count++;
            atomicInteger.incrementAndGet();
            volatileCount++;
            try {
                Thread.sleep(i * 100);
            } catch (InterruptedException e) {
                System.out.println("error");
                throw new RuntimeException(e);
            }
        }
    }
    public int getCount(){
        return this.count;
    }

    public int getAtomicCount(){
        return atomicInteger.get();
    }

    public int getVolatileCount() {return volatileCount;}
}

public class AtomicVsVolatile {

    public static void main(String args[]) throws InterruptedException {
        Task t = new Task();
        Thread t1 = new Thread(t,"Thread t1");
        t1.start();
        Thread t2 = new Thread(t,"Thread t2");
        t2.start();
        Thread t3 = new Thread(t,"Thread t3");
        t1.join();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("Execution done");
        System.out.println("Variable count - "+t.getCount());
        System.out.println("Atomic count - "+t.getAtomicCount());
        System.out.println("Volatile count - "+t.getVolatileCount());
    }
}
