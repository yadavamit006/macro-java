package com.learning.ay.basic.designpattern.decorator;

public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic car building");
    }
}
