package com.learning.ay.basic.exception;

public class ExceptionSample {

    public static void main(String[] args) {
        System.out.println(testReturnValue());
    }

    private static int testReturnValue() {
        try {
            return 1;
        }finally {
            return 2;
        }
    }
}
