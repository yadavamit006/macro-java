package com.learning.ay.basic.record;

public class TestRecord {
    public static void main(String[] args) {
        VotingRecord record = new VotingRecord("Abhinav Arora",19);
        System.out.println(record.age());
        record.sayHello();
        record.print();
    }
}

interface Printable {
    void print();
}