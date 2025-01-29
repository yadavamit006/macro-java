package com.learning.ay.dsa.array.easy;

public class LongestSubArrayWithSumKPositive {
    public static void main(String[] args) {
        bruteForceApproach();
        bruteForceApproach2();
    }

    private static void bruteForceApproach() {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int n = a.length;

        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }
                if (s == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        System.out.println("(bruteForceApproach) LongestSugArraySum of length " + len);
    }

    //Better space complexity O(n2)
    private static void bruteForceApproach2() {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int n = a.length;

        int len = 0;
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = i; j < n; j++) {
                s += a[j];
                if (s == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        System.out.println("(bruteForceApproach) LongestSugArraySum of length " + len);
    }
}
