package com.learning.ay.basic.overloadingandoverriding;

public class Overloading {

    public Integer add(int i) {
        System.out.println("int");
        return Integer.valueOf(i);
    }

    private Double add(double i) {
        System.out.println("double");
        return Double.valueOf(i);
    }

    protected void add(float i) {
        System.out.println("float");
    }

    void add(Object i) {
        System.out.println("Object");
    }

    public void add(int i, int j) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Overloading o = new Overloading();
        o.add(null);
        o.add(1.1);//double
        o.add(1.1f);//float
        o.add(new Object());
    }
}


/*
The overloaded and overloading methods must be in the same class (Note: this includes any methods inherited, even implicitly, from a superclass).
The method parameters must change: either the number or the type of parameters must be different in the two methods.
The return type can be freely modified.
The access modifier (public, private, and so on) can be freely modified.
Thrown exceptions, if any, can be freely modified.
 */