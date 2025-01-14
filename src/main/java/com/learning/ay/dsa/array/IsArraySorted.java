package com.learning.ay.dsa.array;

public class IsArraySorted {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 1, 3};
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i] <= arr[i + 1])) {
                isSorted = false;
            }
        }
        System.out.println(isSorted);
    }
}
