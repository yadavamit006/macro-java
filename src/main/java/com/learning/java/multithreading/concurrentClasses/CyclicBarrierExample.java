package com.learning.java.multithreading.concurrentClasses;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/* A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
The java.util.concurrent.CyclicBarrier class is a barrier that all threads must wait at, until all threads reach it,
 before any of the threads can continue.
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.print("All bikers has arrived at checkpoint. Lets refill petrol."));
        //the total number of parties / threads which wait for each other after reaching the Barrier, barrierAction specifies a thread that will be executed when the barrier is reached
        new Thread(new Biker(cyclicBarrier, "Arun")).start();
        new Thread(new Biker(cyclicBarrier, "Mohan")).start();
        new Thread(new Biker(cyclicBarrier, "Krishna")).start();
    }
}

class Biker extends Thread {

    private final CyclicBarrier cyclicBarrier;
    private final String riderName;

    Biker(CyclicBarrier cyclicBarrier, String riderName) {
        this.cyclicBarrier = cyclicBarrier;
        this.riderName = riderName;
    }

    @Override
    public void run() {
        try {
            System.out.println(riderName + " has reached Mumbai");
            cyclicBarrier.await();//his will suspend the thread until all the thread also call the await() method on the same CyclicBarrier object.
            System.out.println(riderName + " has reached Delhi");//Once all the specified threads have called await() method, they can resume operation.
            cyclicBarrier.await();
            System.out.println(riderName + " has reached Manali");
            cyclicBarrier.await();
            System.out.println(riderName + " completed trip");
        } catch (InterruptedException e) {//InterruptedException – if the current thread was interrupted while waiting
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}