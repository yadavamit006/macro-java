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
    }
}


enum PaymentMethod {
    CREDIT_CARD("CC", "Credit Card") {
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

    PaymentMethod(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public abstract double calculateFees(double amount);

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    private static final Map<String, PaymentMethod> BY_CODE = new HashMap<>();

    static {
        for (PaymentMethod value : PaymentMethod.values()) {
            BY_CODE.put(value.getCode(), value);
        }
    }

    public static PaymentMethod fromCode(String code) {
        return BY_CODE.get(code);
    }
}