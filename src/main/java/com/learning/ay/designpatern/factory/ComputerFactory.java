package com.learning.ay.designpatern.factory;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if (type.equals("PC")) {
            return new PC(ram, hdd, cpu);
        } else if (type.equals("SERVER")) {
            return new Server(ram, hdd, cpu);
        }
        return null;
    }
}
