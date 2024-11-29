package com.learning.ay.multithreading;

//Print Number in Sequence with Multiple thread
//1 %(mod) 3 = 1,a mod b means the value of remainder when we divide a by b. Or 3/1 = 0 Quotient & 1 Remainder
public class PrintNumberSequenceWithMultipleThread {
    public static void main(String[] args) {
        final int numberOfThread = 4;
        final int totalNumberToPrint = 5;
        final NumberGenerator numberGenerator = new NumberGenerator(numberOfThread, totalNumberToPrint);
        new Thread(new SequenceGenerator(numberGenerator, 2), "Thread - 2").start();
        new Thread(new SequenceGenerator(numberGenerator, 3), "Thread - 3").start();
        new Thread(new SequenceGenerator(numberGenerator, 1), "Thread - 1").start();
        new Thread(new SequenceGenerator(numberGenerator, 0), "Thread - 4").start();
    }
}

class NumberGenerator {
    private int currentNumber = 1;
    private final int totalThread;
    private final int totalNumberToPrint;

    NumberGenerator(final int totalThread, final int totalNumberToPrint) {
        this.totalThread = totalThread;
        this.totalNumberToPrint = totalNumberToPrint;
    }

    public void printNumber(int index) {
        synchronized (this) {
            while (currentNumber <= totalNumberToPrint) {
                while (currentNumber % totalThread != index) { // Ex 2%3 = 2-0(3X0)=2 -> 2!=1(index) so True and wait
                    try {
                        wait();// Wait until current thread get notified
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(currentNumber <= totalNumberToPrint){
                    System.out.println(Thread.currentThread().getName() + " - " + currentNumber++); //Ex: 1%3 = 1-0= 1
                }
                notifyAll();
            }
        }
    }
}

class SequenceGenerator implements Runnable {
    private final NumberGenerator numberGenerator;
    private final int index;

    SequenceGenerator(NumberGenerator numberGenerator, int index) {
        this.numberGenerator = numberGenerator;
        this.index = index;
    }

    @Override
    public void run() {
        numberGenerator.printNumber(index);
    }
}