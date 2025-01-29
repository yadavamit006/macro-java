package com.learning.ay.dsa.array;

public class FindMissingNumberArr {

    public static void main(String[] args) {
        bruteForce();
        betterApproach();
        optimalApproach();
    }

    private static void optimalApproach() {
        int[] arr = {1, 2, 3, 5};
        int n = 5;
        int total = n * (n + 1) / 2;
        int sumOfArr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfArr = sumOfArr + arr[i];
        }
        final int missingNumber = total - sumOfArr;
        System.out.println("(Optimal) Missing Number is : " + missingNumber);

    }

    private static void betterApproach() {
        int[] arr = {1, 2, 3, 5};
        int[] hash = new int[arr.length + 1];//hash array

        for (int i = 0; i < arr.length - 1; i++) {
            hash[arr[i]]++;
        }
        for (int i = 1; i <= arr.length; i++) {  // storing the frequencies:
            if (hash[i] == 0) {
                System.out.println("(better) Missing number is : " + i);
            }
        }
    }

    private static void bruteForce() {
        int[] arr = {1, 2, 3, 6};
        for (int i = 1; i <= arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag++;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("(brute) Missing number is : " + i);
            }
        }
    }
}
