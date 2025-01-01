package com.learning.ay.basic.designpattern.decorator;

public class SuperCar extends CarDecorator {
    public SuperCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Creating sports car");
    }
}
