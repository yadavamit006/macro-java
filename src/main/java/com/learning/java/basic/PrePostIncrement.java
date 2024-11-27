package com.learning.java.basic;

public class PrePostIncrement {
    public static void main(String[] args) {
       int a =10;
        a =++a + ++a + ++a;// Goes from left to right
        System.out.println(a);

        int b = 10;
        b = ++b + b++ + ++b; //11 + 11 + 13
        System.out.println(b);

    }
}
