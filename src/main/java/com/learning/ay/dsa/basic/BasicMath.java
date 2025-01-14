package com.learning.ay.dsa.basic;

public class BasicMath {
    public static void main(String[] args) {

        System.out.println("Total Digits");
        getTotalDigits();

        System.out.println("Reserve Number");
        reserveNumber();

        System.out.println("Palindrome Number");
        isPalindromeNumber(1221);
    }

    static void isPalindromeNumber(int n) {
        int revNum = 0;
        int dup = n;
        while (n > 0) {
            int ld = n % 10;
            revNum = (revNum * 10) + ld;
            n = n / 10;
        }
        if (dup == revNum) {
            System.out.print("It is Palindrome");
        } else {
            System.out.print("Not Palindrome");
        }
    }

    private static void reserveNumber() {
        int number = 123;
        int revNumber = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            revNumber = revNumber * 10 + lastDigit;
            number = number / 10;
        }
        System.out.println(revNumber);
    }

    private static void getTotalDigits() {
        int number = 123;
        int totalDigits = 0;
        while (number > 0) {
            totalDigits++;
            number = number / 10;
        }
        System.out.println(totalDigits);
    }
}
