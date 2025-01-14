package com.learning.ay.dsa.array;

public class SecondLargestElement {

    public static void main(String[] args) {
        secondLargestBetter();
        secondLargestOptimal();

        secondSmallest();
    }

    private static void secondSmallest() {
        int arr[] = {1, 4, 7, 7, 5, 2};
        var smallest = arr[0];
        var secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (smallest != arr[i] && arr[i] < secondSmallest ) {
                secondSmallest = arr[i];
            }
        }
        System.out.println("Smallest " + smallest + " Second Smallest " + secondSmallest);
    }

    private static void secondLargestOptimal() {
        int arr[] = {1, 2, 4, 7, 7, 5};
        var largest = arr[0];
        var secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (secondLargest < arr[i] && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest " + largest + " Second " + secondLargest);

    }

    private static void secondLargestBetter() {
        int arr[] = {2, 3, 5, 6, 6, 1};

        var largestElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) {
                largestElement = arr[i];
            }
        }
        var secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] < largestElement) {
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }
}
