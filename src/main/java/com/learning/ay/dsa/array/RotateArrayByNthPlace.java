package com.learning.ay.dsa.array;

import java.util.Arrays;

public class RotateArrayByNthPlace {

    public static void main(String[] args) {
        rotateByOnePlace();
        rotateByNthPlace();
    }

    private static void rotateByNthPlace() {
        int[] arr = {3, 9, 8, 7, 4};
        int n = arr.length;
        int r = 8;//rotate Array by Nth
        int d = r % n;
        rotateArray(arr, 0, d - 1);
        rotateArray(arr, d, n - 1);
        rotateArray(arr, 0, n - 1);
        System.out.println("RotateByNthPlace - " + Arrays.toString(arr));
    }

    private static void rotateArray(int[] arr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    private static void rotateByOnePlace() {
        int[] arr = {1, 2, 3, 4, 5};
        if (arr.length > 1) {
            int lastIndexValue = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = lastIndexValue;
        }
        System.out.println("RotateByOnePlace - " + Arrays.toString(arr));
    }
}
