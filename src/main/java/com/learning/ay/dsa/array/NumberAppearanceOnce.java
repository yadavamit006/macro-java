package com.learning.ay.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class NumberAppearanceOnce {
    public static void main(String[] args) {
        betterApproachSelf();
        bruteForce();
    }

    private static void bruteForce() {
        int[] arr = {4, 4, 2, 2, 2, 5};
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("(bruteForce) Minimum occurrence number is " + arr[i]);
            }
        }
    }

    private static void betterApproachSelf() {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {4, 1, 2, 1, 2};
        for (int i = 0; i < arr.length; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], ++count);
        }
        map.forEach((x, y) -> {
            if (y.intValue() == 1) {
                System.out.println("(betterApproachSelf) Minimum occurrence number is " + x);
            }
        });

        /*for (Map.Entry<Integer, Integer> maps : map.entrySet()) {
            if (maps.getValue() == 1) {

            }
        }*/
    }
}
