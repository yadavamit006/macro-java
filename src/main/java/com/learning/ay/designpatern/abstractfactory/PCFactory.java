package com.learning.ay.designpatern.abstractfactory;

public class PCFactory extends AbstractComputerFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    Computer createComputer() {
        return new PC(this.ram, this.hdd, this.cpu);
    }
}
