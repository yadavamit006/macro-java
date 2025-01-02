package com.learning.ay.designpatern.builder;

public class BuilderMainMethod {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("5gb", "250gb").isGraphicEnabled(true).build();
        System.out.println(computer.toString());

    }
}
