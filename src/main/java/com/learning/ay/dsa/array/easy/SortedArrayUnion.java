package com.learning.ay.dsa.array.easy;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayUnion {
    public static void main(String[] args) {
        optimizedCode();
    }

    private static void optimizedCode() {
        List<Integer> a = List.of(1, 2, 2, 3, 4);
        List<Integer> b = List.of(2, 3, 5, 6);
        int n1 = a.size();
        int n2 = b.size();
        int i = 0, j = 0;
        List<Integer> uniqueArr = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a.get(i) <= b.get(j)) {
                if (uniqueArr.isEmpty() || !uniqueArr.get(uniqueArr.size() - 1).equals(a.get(i))) {
                    uniqueArr.add(a.get(i));
                }
                i++;
            } else {
                if (uniqueArr.isEmpty() || !uniqueArr.get(uniqueArr.size() - 1).equals(b.get(j))) {
                    uniqueArr.add(b.get(j));
                }
                j++;
            }
        }
        while (i < n1) {
            if (uniqueArr.isEmpty() || !uniqueArr.get(uniqueArr.size() - 1).equals(a.get(i))) {
                uniqueArr.add(a.get(i));
            }
            i++;
        }
        while (j < n2) {
            if (uniqueArr.isEmpty() || !uniqueArr.get(uniqueArr.size() - 1).equals(b.get(j))) {
                uniqueArr.add(b.get(j));
            }
            j++;
        }
        System.out.println(uniqueArr);
    }
}
