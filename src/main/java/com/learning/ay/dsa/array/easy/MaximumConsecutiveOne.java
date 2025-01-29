package com.learning.ay.dsa.array.easy;

public class MaximumConsecutiveOne {

    public static void main(String[] args) {
        //bruteApproachSelf();
        otherApproach();
    }

    private static void otherApproach() {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 0, 0, 1};
        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }
        System.out.println("(otherApproach) Maximum : "+maxi);
    }

    private static void bruteApproachSelf() {
        int[] arr = {1, 1, 0, 1, 1, 1, 0, 0, 0, 1};
        int maxConsecutiveOne = 0;
        for (int i = 0; i < arr.length ; i++) {
            int count = 0;
            if (arr[i] == 1) {
                count++;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        i++;
                        continue;
                    }
                    if (count > maxConsecutiveOne) {
                        maxConsecutiveOne = count;
                        break;
                    }
                }
            }
        }
        System.out.println("(brute) Max Consecutive Number count : " + maxConsecutiveOne);
    }
}