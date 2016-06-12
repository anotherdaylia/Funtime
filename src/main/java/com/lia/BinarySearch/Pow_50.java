package com.lia.BinarySearch;

/**
 * Created by liqu on 6/8/16.
 */
public class Pow_50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x = 1/x * 1/x;
            } else {
                x = 1/x;
                n = -n;
            }
        }

        double result = 0;
        if (n % 2 == 0) result += myPow(x*x, n/2);
        else  result += x*myPow(x*x, n/2);

        return result;
    }
}
