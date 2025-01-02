package com.learning.ay.designpatern.builder;

public class Computer {

    private String ram;
    private String hdd;
    private Boolean isBluetoothEnabled;
    private Boolean isGraphicEnabled;

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public Boolean getBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    public Boolean getGraphicEnabled() {
        return isGraphicEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isGraphicEnabled=" + isGraphicEnabled +
                '}';
    }

    public Computer(ComputerBuilder computerBuilder) {
        this.ram = computerBuilder.ram;
        this.hdd = computerBuilder.hdd;
        this.isGraphicEnabled = computerBuilder.isGraphicEnabled;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        private String ram;
        private String hdd;
        private Boolean isBluetoothEnabled = false;
        private Boolean isGraphicEnabled = false;


        ComputerBuilder(String ram, String hdd) {
            this.ram = ram;
            this.hdd = hdd;
        }

        public ComputerBuilder isGraphicEnabled(Boolean isGraphicEnabled) {
            this.isGraphicEnabled = isGraphicEnabled;
            return this;
        }

        public ComputerBuilder isBluetoothEnabled(Boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }
}
