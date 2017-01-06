package com.lia.Math;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 *
 * Created by liqu on 9/26/16.
 */
public class UglyNumber_263 {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int[] factors = {2, 3, 5};

        for (int factor : factors) {
            while (num % factor == 0){
                num /= factor;
            }
        }
        return num == 1;
    }
}
