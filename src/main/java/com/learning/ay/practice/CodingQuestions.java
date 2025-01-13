package com.learning.ay.practice;

import java.util.*;
import java.util.stream.Collectors;

public class CodingQuestions {
    public static void main(String[] args) {
        swapTwoNumberOfDigit();
        findNthSalary(2);
    }

    public static void findNthSalary(int nth) {
        Map<String, Integer> map = new HashMap<>();
        map.put("vivek", 100);
        map.put("Rinku", 400);
        map.put("vishal", 600);
        map.put("shankar", 500);
        map.put("shyam", 500);
        map.put("tinku", 300);
        Map.Entry<Integer, List<String>> name = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream().sorted(Collections.reverseOrder((c1, c2) -> c1.getKey().compareTo(c2.getKey())))
                .toList()
                .get(nth - 1);
        System.out.println(name);
        //Method Reference : Map.Entry.comparingByKey() in lambda : (c1, c2) -> c1.getKey().compareTo(c2.getKey())
    }

    private static void swapTwoNumberOfDigit() {
        Integer[] arr = {1, 1, 0, 1, 0};
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}


