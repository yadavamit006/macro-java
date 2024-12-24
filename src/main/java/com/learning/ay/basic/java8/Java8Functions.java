package com.learning.ay.basic.java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8Functions {

    static Predicate<Integer> evenNumbers = (num) -> num % 2 == 0;
    static Predicate<Integer> oddNumbers = (num) -> num % 2 != 0;

    static Function<Integer, Integer> squareNumber = (num) -> num * num;

    static BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            return integer + integer2;
        }
    };

    static Consumer<Integer> consumer = System.out::println;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Even Number print ------->");
        numbers.stream().filter(evenNumbers).forEach(System.out::println);
        System.out.println("Odd Number print ------->");
        numbers.stream().filter(oddNumbers).forEach(consumer);
        System.out.println("Square Number print ------->");
        numbers.stream().map(squareNumber).forEach(System.out::println);
        System.out.println("Binary Operator sum all number print ------->");
        System.out.println(numbers.stream().reduce(0, binaryOperator));
    }
}
