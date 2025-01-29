package com.learning.ay.dsa.array.easy;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateElementAtInitial {
    public static void main(String[] args) {
        optimalApproach();
        bruteForceApproach();
    }
    private static void bruteForceApproach() {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4};
        HashSet<Integer> unique = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            unique.add(arr[i]);
        }
        int index = 0;
        for (Integer num : unique) {
            arr[index] = num;
            index++;
        }
        System.out.println("bruteForceApproach : "+Arrays.toString(arr));
    }

    private static void optimalApproach() {
        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4};
        int uniqueindexposition = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1]) {
                uniqueindexposition++;
                arr[uniqueindexposition] = arr[i+1];
            }
        }
        System.out.println("bruteForceOption : "+Arrays.toString(arr));
    }
}
