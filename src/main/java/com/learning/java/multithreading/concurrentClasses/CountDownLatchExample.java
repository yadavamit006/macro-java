package com.learning.java.multithreading.concurrentClasses;

import java.util.concurrent.CountDownLatch;
//A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads complete.
/* CountDownLatch in Java Concurrency is a type of synchronizer which allows one Thread to wait for one or more Threads before it starts processing.
You can implement the same functionality using wait() & Notify() mechanism but it requires a lot of code and getting it write in first attempt is tricky,
With CountDownLatch it can  be done in just few lines.It was introduced in Java 5 along with other concurrent classes like CyclicBarrier,
 ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue within java.util.Concurrent package. https://codepumpkin.com/countdownlatch-java-concurrency/ */
public class CountDownLatchExample {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread t1 = new Thread(new Employee(countDownLatch, "Emp 1"));
        Thread t2 = new Thread(new Employee(countDownLatch, "Emp 2"));
        Thread t3 = new Thread(new Employee(countDownLatch, "Emp 3"));
        t1.start();
        t2.start();
        t3.start();
        try {
            System.out.println("Total Employee - " + countDownLatch.getCount());
            countDownLatch.await();
            System.out.println("All employees have taken there seat, driver can start");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Employee implements Runnable {
        private final CountDownLatch countDownLatch;
        private final String empName;

        public Employee(CountDownLatch countDownLatch, String empName) {
            this.countDownLatch = countDownLatch;
            this.empName = empName;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Employee " + this.empName + " has taken seat");
            countDownLatch.countDown();
            System.out.println("After " + this.empName + "  Total Count" + countDownLatch.getCount());
        }
    }
}
//CountDown Latch cannot be reused. Once the countdown reaches zero any further call to await() method won't block any thread.