package com.learning.ay.basic.record;

public record VotingRecord(String name, Integer age) implements Printable {
    public VotingRecord{
        if(age<18){
            throw new IllegalArgumentException("You are not allowed to vote");
        }
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    @Override
    public void print() {
        System.out.println("Printing User Voting Id");
    }
}
