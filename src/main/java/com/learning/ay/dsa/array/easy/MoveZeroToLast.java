package com.learning.ay.dsa.array.easy;

import java.util.Arrays;

public class MoveZeroToLast {
    public static void main(String[] args) {
        //bruteForceApproach();
        optimalApproach();
    }

    private static void optimalApproach() {
        int arr[] = {0, 0, 1, 0, 3, 3, 0, 1, 0, 9};
        int p2 = 0;
        for (int p1 = 0; p1 < arr.length; p1++) {
            if (arr[p1] > 0) {
                int temp = arr[p2];
                arr[p2] = arr[p1];
                arr[p1] = temp;
                p2++;
            }
        }
        System.out.println("optimalApproach - "+Arrays.toString(arr));
    }

    private static void bruteForceApproach() {
        int arr[] = {0, 0, 1, 0, 3, 3, 0, 1, 0, 9};
        int initialPositionIndex = 0, zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[initialPositionIndex] = arr[i];
                arr[i] = 0;
                zeroCount++;
                initialPositionIndex++;
            }
        }
        for (int i = zeroCount + 1; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
