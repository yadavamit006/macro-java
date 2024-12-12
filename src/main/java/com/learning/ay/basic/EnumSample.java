package com.learning.ay.basic;

import java.util.HashMap;
import java.util.Map;

public class EnumSample {
    public static void main(String[] args) {
        System.out.println(PaymentMethod.CREDIT_CARD.getCode() + " " + PaymentMethod.CREDIT_CARD.getDescription());
        for (PaymentMethod value : PaymentMethod.values()) {
            System.out.println("Payment Method " + value.getCode() + "-" + value.getDescription() + ", calculateFees " + value.calculateFees(100));
        }

        PaymentMethod fetchMethod = PaymentMethod.fromCode("CC");
        System.out.println("Fetched Method : "+fetchMethod);
        //Saved some changes in local now moving to other branch
    }
}

//Extend java.lang.enum cant extend any other class. however can implement interface
enum PaymentMethod {
    CREDIT_CARD("CC", "Credit Card") { //Constants with Associated Fields(name & Desc)
        @Override
        public double calculateFees(double amount) {
            return amount * 3;
        }
    }, DEBIT_CARD("DC", "Debit card") {
        @Override
        public double calculateFees(double amount) {
            return amount * 2;
        }
    };

    private final String code;
    private final String description;

    PaymentMethod(String code, String description) {//Private constructor only
        this.code = code;
        this.description = description;
    }

    public abstract double calculateFees(double amount); //Abstract Method

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    private static final Map<String, PaymentMethod> BY_CODE = new HashMap<>(); //static Map for look-up

    static {
        for (PaymentMethod value : PaymentMethod.values()) { //values() : return array of all enum constants
            BY_CODE.put(value.getCode(), value);
        }
    }

    public static PaymentMethod fromCode(String code) { //Custom method
        return BY_CODE.get(code);
    }
}