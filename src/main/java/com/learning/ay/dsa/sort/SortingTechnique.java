package com.learning.ay.dsa.sort;

import java.util.Arrays;

public class SortingTechnique {
    public static void main(String[] args) {
        //selectionSort();
        //bubbleSort();
        insertionSort();
    }

    /*
    Concept: Build the sorted part of the array one element at a time by inserting elements into their correct position.
    Algorithm:
        Start with the second element as the key.
        Compare the key with elements of the sorted part and move elements one position ahead if they are larger.
        Insert the key in its correct position.
        Repeat for all remaining elements.*/
    private static void insertionSort() {
        int[] numbs = {9, 1, 23, 2, 15, 7};
        int n = numbs.length;
        for (int i = 1; i < n; i++) {
            int key = numbs[i];
            int j = i - 1;
            // Move elements of arr[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && numbs[j] > key) {
                numbs[j + 1] = numbs[j];
                j--;
            }
            numbs[j + 1] = key;
        }
    }

    /*
    Concept: Repeatedly swap adjacent elements if they are in the wrong order. Each pass "bubbles" the largest element to its correct position.
    Algorithm:
        1. Compare adjacent elements.
        2. Swap them if they are in the wrong order.
        3. Repeat for the remaining unsorted part until no swaps are needed.*/
    private static void bubbleSort() {
        int[] numbs = {9, 1, 23, 2, 15, 7};
        int n = numbs.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    int temp = numbs[j];
                    numbs[j] = numbs[j + 1];
                    numbs[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbs));
    }

    /*
    Concept: Repeatedly find the smallest (or largest) element from the unsorted part of the array and place it at the beginning.
    Algorithm:
        1. Start with the first element as the current minimum.
        2. Compare the current element with all the other elements in the unsorted part.
        3. Swap the smallest element found with the first element of the unsorted part.
        4. Repeat for the remaining unsorted portion of the array.*/
    private static void selectionSort() {
        int[] numbs = {9, 1, 23, 2, 15, 7};
        int n = numbs.length;
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (numbs[j] < numbs[mini]) {
                    mini = j;
                }
            }
            int temp = numbs[i];
            numbs[i] = numbs[mini];
            numbs[mini] = temp;
        }
        System.out.println(Arrays.toString(numbs));
    }
}
