package com.learning.ay.dsa.sort;

import java.util.Arrays;

public class SortingTechnique {
    public static void main(String[] args) {
        //selectionSort();
        //bubbleSort();
        insertionSortAnotherApproach();
    }

    /*
    Concept: Build the sorted part of the array one element at a time by inserting elements into their correct position.
    Algorithm:
        Start with the second element as the key.
        Compare the key with elements of the sorted part and move elements one position ahead if they are larger.
        Insert the key in its correct position.
        Repeat for all remaining elements.*/
    private static void insertionSort() {
        int[] arr = {9, 1, 23, 2, 15, 7};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void insertionSortAnotherApproach() {
        int[] arr = {9, 1, 23, 2, 15, 7};
        int n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    Concept: Repeatedly swap adjacent elements if they are in the wrong order. Each pass "bubbles" the largest element to its correct position.
    Algorithm:
        1. Compare adjacent elements.
        2. Swap them if they are in the wrong order.
        3. Repeat for the remaining unsorted part until no swaps are needed.*/
    private static void bubbleSort() {
        int[] arr = {9, 1, 23, 2, 15, 7};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
    Concept: Repeatedly find the smallest (or largest) element from the unsorted part of the array and place it at the beginning.
    Algorithm:
        1. Start with the first element as the current minimum.
        2. Compare the current element with all the other elements in the unsorted part.
        3. Swap the smallest element found with the first element of the unsorted part.
        4. Repeat for the remaining unsorted portion of the array.*/
    private static void selectionSort() {
        int[] arr = {9, 1, 23, 2, 15, 7};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
