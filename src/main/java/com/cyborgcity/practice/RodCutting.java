package com.cyborgcity.practice;

/**
 * Created by Ravi on 21-03-2017.
 */
public class RodCutting {

    public static int profitDP(int[] value, int length) {
        int[] solution = new int[length + 1];
        solution[0] = 0;

        for (int i = 1; i <= length; i++) {
            int max = -1;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, value[j] + solution[i - (j + 1)]);
                solution[i] = max;
            }
        }
        return solution[length];
    }

    public static void main(String[] args) {
        int[] value = {0, 2, 3, 7, 8, 9 };
        int len = 5;
        System.out.println("Max profit for length is " + len + ":"
                + profitDP(value, len));

    }
}
