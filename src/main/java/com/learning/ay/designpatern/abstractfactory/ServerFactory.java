package com.learning.ay.designpatern.abstractfactory;

public class ServerFactory extends AbstractComputerFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    Computer createComputer() {
        return new Server(this.ram, this.hdd, this.cpu);
    }
}
