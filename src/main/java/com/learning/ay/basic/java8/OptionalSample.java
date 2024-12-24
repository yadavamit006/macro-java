package com.learning.ay.basic.java8;

import java.util.Optional;

public class OptionalSample {

    public static void main(String[] args) {
        Optional<String> requireNonNull = Optional.of("Hello World");
        if (requireNonNull.isPresent()) {
            System.out.println(requireNonNull.get());
        }

        Optional<String> nullValueAccepted = Optional.ofNullable(null);
        if (nullValueAccepted.isEmpty()) {
            System.out.println("Null value");
        }
    }
}
