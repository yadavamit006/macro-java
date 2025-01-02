package com.learning.ay.designpatern.abstractfactory;

public class TestDesignPattern {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.getComputer(new PCFactory("50gb", "350GB", "43"));
        System.out.println(computer.toString());
    }
}
