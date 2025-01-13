package com.learning.ay.basic.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Macro {
    public static void main(String[] args) {
        //findDuplicateWordInArray();
        //findWordStartsWithAInArray();
        //findDuplicateCharacterInString();
        //findNthSalary(2);
        //findUniqueCharacter();
        //firstNonRepeatingCharacter();
        findSecondHighestWithBoxedMethod();

    }

    private static void findSecondHighestWithBoxedMethod() {
        int[] arr = {1, 2, 3, 3, 3, 6, 7, 3, 23, 3, 4, 5};
        Optional<Integer> value = Arrays.stream(arr).boxed().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
        value.ifPresent(System.out::println);
    }

    private static void findUniqueCharacter() {
        String str = "amityadav";
        stream(str.split("")).collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
                .entrySet().stream().filter(ch->ch.getValue()==1).toList().forEach(System.out::println);
    }

    private static void firstNonRepeatingCharacter(){
        String str = "amityadav";

        String sd = stream(str.split("")).collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(ch->ch.getValue()==1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(sd);
    }

    private static void findDuplicateCharacterInString() {
        String str = "ashokav vatika";
        stream(str.split("")).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet().stream().filter(ch -> ch.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet().forEach(System.out::println);
    }

    private static void findWordStartsWithAInArray() {
        String[] str = {"java", "springBoot", "aws", "c#", "react", "rust", "azure"};
        stream(str).filter(sub -> sub.startsWith("a")).map(sub -> "I will learn " + sub).toList().forEach(System.out::println);
    }

    private static void findDuplicateWordInArray() {
        String[] str = {"java", "springboot", "aws", "c#", "react", "rust", "azure"};
        stream(str).collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting())).entrySet().forEach(System.out::println);
    }
}
