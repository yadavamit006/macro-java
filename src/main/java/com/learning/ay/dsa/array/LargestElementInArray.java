package com.learning.ay.dsa.array;

import java.util.Arrays;
import java.util.Optional;

public class LargestElementInArray {

    public static void main(String[] args) {
        int arr[] = {2, 5, 1, 3, 0};
        //Option
        var maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println(maxValue);

        //Option
        Optional<Integer> max = Arrays.stream(arr).boxed()
                .sorted((a, b) -> b.compareTo(a))
                .findFirst();
        max.ifPresent(System.out::println);

        //Option
        Integer max1 = Arrays.stream(arr).max().getAsInt();
        System.out.println(max1);


    }
}
