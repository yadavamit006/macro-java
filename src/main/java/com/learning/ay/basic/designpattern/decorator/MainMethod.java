package com.learning.ay.basic.designpattern.decorator;

public class MainMethod {
    public static void main(String[] args) {
        Car c = new SuperCar(new BasicCar());
        c.assemble();
        System.out.println("Now create Luxury Car from SportsCar");

        Car luxuryCar = new LuxuryCar(new SuperCar(new BasicCar()));
        luxuryCar.assemble();
    }
}
