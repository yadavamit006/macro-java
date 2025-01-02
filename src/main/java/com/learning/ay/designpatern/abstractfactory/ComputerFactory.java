package com.learning.ay.designpatern.abstractfactory;

public class ComputerFactory {

    public static Computer getComputer(AbstractComputerFactory abstractComputerFactory) {
        return abstractComputerFactory.createComputer();
    }
}