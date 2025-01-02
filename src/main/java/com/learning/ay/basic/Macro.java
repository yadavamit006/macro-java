package com.learning.ay.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Macro {

    @MyCustomAnnotation(value = "MyValue",priority = 2,type = "Google")
    public void testArgs(){

    }
    public static void main(String[] args) {
        System.out.println("hello");

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        Stream<String> collect = list.stream().filter(str-> str.equals("abc"));
        System.out.println(collect.toList().size());
        List.of(collect);
    }
}
