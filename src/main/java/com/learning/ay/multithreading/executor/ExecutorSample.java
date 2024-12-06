package com.learning.ay.multithreading.executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorSample {
    public static void main(String[] args) throws InterruptedException {

        //Single
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> 1);
        executor.submit(() -> 2);
        executor.submit(() -> {
            System.out.println("Task 3 executed asynchronously");
        });
        executor.shutdown();
        boolean terminated = executor.awaitTermination(10, TimeUnit.SECONDS);
        if (terminated) {
            System.out.println("All tasks have completed execution");
        } else {
            System.out.println("Timeout occurred before all tasks completed");
        }

        //Cached and invokeAny
        ExecutorService executorCached = Executors.newCachedThreadPool();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> "Task 1");
        callables.add(() -> "Task 2");
        String result;
        try {
            result = executorCached.invokeAny(callables);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Result: " + result);

        //New Fixed thread pool and invokeAll
        ExecutorService executorFixed = Executors.newFixedThreadPool(3);
        Set<Callable<String>> callFixedSixed = new HashSet<>();
        callFixedSixed.add(() -> "Task 1");
        callFixedSixed.add(() -> "Task 2");
        List<Future<String>> results = executorFixed.invokeAll(callFixedSixed);
        System.out.println("Result: " + result);
        for (Future<String> stringFuture : results) {
            try {
                System.out.println("Get Value: " + stringFuture.get() + " Done : " + stringFuture.isDone());
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        // Create a ScheduledThreadPoolExecutor with 2 threads
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        // Schedule a task with a 2-second delay
        Runnable task1 = () -> System.out.println("Executing task 1 after a delay");
        scheduler.schedule(task1, 2, TimeUnit.SECONDS);
        // Schedule a task to run every 5 seconds with a fixed rate
        Runnable task2 = () -> System.out.println("Executing task 2 at fixed rate");
        scheduler.scheduleAtFixedRate(task2, 1, 5, TimeUnit.SECONDS);
        // Schedule a task to run every 3 seconds with a fixed delay
        Runnable task3 = () -> System.out.println("Executing task 3 with fixed delay");
        scheduler.scheduleWithFixedDelay(task3, 0, 3, TimeUnit.SECONDS);
        // Wait for some time to allow tasks to be executed
        Thread.sleep(1500);
        // Shutdown the scheduler
        scheduler.shutdown();
    }
}
