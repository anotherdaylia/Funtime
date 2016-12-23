package com.lia.StringTag;

/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * Created by liqu on 10/9/16.
 */
public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        /*Convert string numbers to char, c1 is always the longer one*/
        char[] c1 = (num1.length() > num2.length()) ? num1.toCharArray() : num2.toCharArray();
        char[] c2 = (num1.length() > num2.length()) ? num2.toCharArray() : num1.toCharArray();

        int carry = 0;
        int diff = c1.length - c2.length;
        for (int i = c1.length - 1; i >= 0; i--) {
            int n1 = c1[i] - '0';
            int n2 = (i < c1.length - c2.length) ? 0 : c2[i - diff] - '0';
            int sum = n1 + n2 + carry;
            c1[i] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        return (carry != 0) ? carry + String.valueOf(c1) : String.valueOf(c1);
    }
}
