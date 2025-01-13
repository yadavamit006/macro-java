package com.learning.ay.designpatern.factory;

public class CallingMethod {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.getComputer("PC", "8GB", "500GB", "20");
        System.out.println(computer.toString());
    }
}
