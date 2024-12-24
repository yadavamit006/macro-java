package com.learning.ay.basic.java8;


import org.aspectj.weaver.loadtime.definition.LightXMLParser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSample {
    public static void main(String[] args) {
        //Create Stream<T> from list of Integer using Stream.of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        List<Integer> list = integerStream.collect(Collectors.toList());
        list.forEach(System.out::println);

        //Convert list to Map
        Stream<Integer> integerStreamForMap = Stream.of(1, 2, 3);
        Map<Integer, Integer> intMap = integerStreamForMap.collect(Collectors.toMap(input -> input, input -> input + 10));
        intMap.forEach((k, v) -> System.out.println("Key - " + k + ", Value - " + v));//https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map

        //Filter element
        List<Integer> oldPeople = Stream.of(30, 89, 44, 60, 56, 100, 78).filter(age -> age >= 60).collect(Collectors.toList());
        oldPeople.forEach(System.out::println);

        //Map function use
        Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);

        //Sorted
        Stream.of("d", "c", "a").sorted().forEach(System.out::println);

        //Flatmap use when nested array,list,set ex Stream<List<String>> -> flatMap -> Stream<String>, Stream<String[]> -> flatMap-> Stream<String>
        Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 5, 6)).flatMap(List::stream).forEach(System.out::println);

        //Sort
        List<Integer> integers = Arrays.asList(1, 2, 44, 7, 8, 5, 9, 6);
        integers.sort((Integer a1, Integer a2) -> { // similar way .sort((a1,a2)->a1 - a2):
            if (a1 > a2) return 1;
            else if (a1 < a2) return -1;
            else return 0;
        });
        System.out.println(integers);
    }
}
