package com.learning.ay.multithreading.executor;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueuesExample {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);
        blockingQueue.add("First Element");
        blockingQueue.add("Second Element");
        System.out.println("Remaining Capacity " + blockingQueue.remainingCapacity());
        try {
            blockingQueue.add("Third Element");
        } catch (IllegalStateException e) {
            System.out.println(e);
        }

        ThreadPoolExecutor tp = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        tp.execute(() -> System.out.println("Task 1"));
        tp.execute(() -> System.out.println("Task 2"));
        tp.execute(() -> System.out.println("Task 3"));
        tp.execute(() -> System.out.println("Task 4"));
        System.out.println("Current PoolSize : " + tp.getPoolSize() + ", ActiveCount : " + tp.getActiveCount());
        tp.execute(() -> System.out.println("Task 5"));
        tp.shutdown();

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Hello");
        threadLocal.get();
    }
}
