package com.lia.StringTag;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.

 * Created by liqu on 5/3/16.
 */
public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        // make num2 the shorter string
        if (num1.length() < num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        //reuse the multiplied results
        String[] prod =  new String[10];
        prod[0] = "0";
        for (int i = 1; i < 10; i++) { prod[i] = "N"; }

        // Saving the string multiply to a string array
        String[] numbers = new String[num2.length()];
        StringBuilder sb = new StringBuilder();
        int carry;
        for (int i = num2.length() - 1; i >= 0; i--) {
            if (!prod[num(num2, i)].equals("N")) {
                numbers[i] = prod[num(num2, i)];
            } else {
                carry = 0;
                int cur = num(num2, i);
                for (int j = num1.length() - 1; j >= 0; j--) {
                    sb.insert(0, (num(num1, j) * cur + carry) % 10);
                    carry = (num(num1, j) * cur + carry) / 10;
                }
                int c = 0;
                while (c < num2.length() - 1 - i) {
                    sb.append('0');
                    c++;
                }
                if (carry != 0) sb.insert(0, carry);
                numbers[i] = sb.toString();
                sb.setLength(0);
            }
        }

        // adding numbers in the string array
        carry = 0;
        for (int i = 0; i < numbers[0].length(); i++) {
            int sum = 0;
//            for (int j = 0; j < numbers.length; j++) {
//                int tmp =  (numbers[j].length() - 1 - i < 0) ? 0 : numbers[j].charAt(numbers[j].length() - 1 - i) - 48;
//                sum += tmp;
//            }
            for (String number : numbers) {
                int tmp = (number.length() - 1 - i < 0) ? 0 : number.charAt(number.length() - 1 - i) - 48;
                sum += tmp;
            }
            sum += carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0){
            sb.insert(0 , carry);
        }

        // remove leading '0's
        int nonzero = 0;
        while (nonzero < sb.length() - 1) {
            if (sb.charAt(nonzero) != '0') break;
            else nonzero++;
        }
        return sb.substring(nonzero);
    }

    private int num(String s, int index) {
        return s.charAt(index) - 48;
    }

    public String multiplySlower(String num1, String num2) {
        // make num2 the shorter string
        if (num1.length() < num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        // to reuse the multiplied results
        String[] prod =  new String[10];
        prod[0] = "0";
        for (int i = 1; i < 10; i++) { prod[i] = "N"; }

        // Saving the string multiply to a string array
        String product = "0";
        StringBuilder sb = new StringBuilder();
        StringBuilder addhelper = new StringBuilder();

        for (int i = num2.length() - 1; i >= 0; i--) {
            if (!prod[num(num2, i)].equals("N")) {
                addhelper.setLength(0);
                product = addTwoStrings(product, prod[num(num2, i)], addhelper);

            } else {
                int carry = 0;
                int cur = num(num2, i);
                for (int j = num1.length() - 1; j >= 0; j--) {
                    sb.insert(0, (num(num1, j) * cur + carry) % 10);
                    carry = (num(num1, j) * cur + carry) / 10;
                }
                int c = 0;
                while (c < num2.length() - 1 - i) {
                    sb.append('0');
                    c++;
                }
                if (carry != 0) sb.insert(0, carry);
                addhelper.setLength(0);
                product = addTwoStrings(product, sb.toString(), addhelper);
                sb.setLength(0);
            }
        }

        // remove leading '0's
        int nonzero = 0;
        sb = new StringBuilder(product);
        while (nonzero < sb.length() - 1) {
            if (sb.charAt(nonzero) != '0') break;
            else nonzero++;
        }
        return sb.substring(nonzero);
    }

    private String addTwoStrings(String s1, String s2, StringBuilder sb) {
        int carry = 0;
        int length = (s1.length() > s2.length()) ? s1.length() : s2.length();
        //StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int tmp1 = (s1.length() - 1 - i < 0) ? 0 : s1.charAt(s1.length() - 1 - i) - 48;
            int tmp2 = (s2.length() - 1 - i < 0) ? 0 : s2.charAt(s2.length() - 1 - i) - 48;
            int sum = tmp1 + tmp2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) sb.insert(0 , carry);
        return sb.toString();
    }
}
