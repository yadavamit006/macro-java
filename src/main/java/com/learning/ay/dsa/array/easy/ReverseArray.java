package com.learning.ay.dsa.array.easy;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        approachWhile(arr);
        approachArray(arr);
    }

    private static void approachArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            var temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void approachWhile(int[] arr) {
        int p1 = 0, p2 = arr.length - 1;
        while (p1 < p2) {
            var temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
