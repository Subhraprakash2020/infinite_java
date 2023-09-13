package com.java.pratice;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first large number: ");
        String number1Str = scanner.nextLine();

        System.out.print("Enter the second large number: ");
        String number2Str = scanner.nextLine();

        int[] result = multiplyLargeNumbers(number1Str, number2Str);
        
        System.out.print("Result: ");
        for (int digit : result) {
            System.out.print(digit);
        }

        scanner.close();
    }

    public static int[] multiplyLargeNumbers(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        return result;
    }
}

