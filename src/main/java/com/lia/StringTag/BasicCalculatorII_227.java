package com.lia.StringTag;

import java.util.ArrayList;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 *
 * Created by liqu on 5/1/16.
 */
public class BasicCalculatorII_227 {
    public int calculate(String s) {
        //since Strings are immutable it is important that you assign the return value of the regex back to s.
        s = s.replaceAll("\\s+", "");

        ArrayList<Integer> initSeq = new ArrayList<> ();

        // initialize the arithmetic sequence
        int op1 = -1, op2 = -1;
        while (op2 < s.length() - 1) {
            op2++;
            if (s.charAt(op2) == '+' ) {
                initSeq.add(Integer.valueOf(s.substring(op1 + 1, op2)));
                initSeq.add(-1);
                op1 = op2;
            } else if (s.charAt(op2) == '-' ) {
                initSeq.add(Integer.valueOf(s.substring(op1 + 1, op2)));
                initSeq.add(-2);
                op1 = op2;
            } else if (s.charAt(op2) == '*' ) {
                initSeq.add(Integer.valueOf(s.substring(op1 + 1, op2)));
                initSeq.add(-3);
                op1 = op2;
            } else if (s.charAt(op2) == '/' ) {
                initSeq.add(Integer.valueOf(s.substring(op1 + 1, op2)));
                initSeq.add(-4);
                op1 = op2;
            }
        }
        initSeq.add(Integer.valueOf(s.substring(op1 + 1, op2 + 1)));
        //System.out.println("init: " + initSeq.toString());

        ArrayList<Integer> opSeq = new ArrayList<>();

        // multiply and divide pass
        for (int op = 0; op < initSeq.size(); op++) {
            int cur = initSeq.get(op);
            if (cur == -3) {
                opSeq.set(opSeq.size() - 1, opSeq.get(opSeq.size() - 1) * initSeq.get(op + 1));
                op++;
            } else if (cur == -4) {
                opSeq.set(opSeq.size() - 1, opSeq.get(opSeq.size() - 1) / initSeq.get(op + 1));
                op++;
            } else {
                opSeq.add(cur);
            }
        }

        // reuse the 1st arraylist
        initSeq.clear();
        //System.out.println("mid: " + opSeq.toString());

        //plus and minus pass
        for (int op = 0; op < opSeq.size(); op++) {
            int cur = opSeq.get(op);
            if (cur == -1) {
                initSeq.set(initSeq.size() - 1, initSeq.get(initSeq.size() - 1) + opSeq.get(op + 1));
                op++;
            } else if (cur == -2) {
                initSeq.set(initSeq.size() - 1, initSeq.get(initSeq.size() - 1) - opSeq.get(op + 1));
                op++;
            } else {
                initSeq.add(cur);
            }
        }

        //System.out.println("final: " + initSeq.toString());
        return initSeq.get(0);
    }

    // https://leetcode.com/discuss/97604/explanation-for-java-o-n-time-%26-o-1-space-solution
    public int calculateOn(String s) {
        int pre = 0, curr = 0, sign = 1, op = 0, num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    curr = (op == 0 ? num : (op == 1 ? curr * num : curr / num));
                }

            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                op = (s.charAt(i) == '*' ? 1 : -1);
                num = 0;

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                pre += sign * curr;
                sign = (s.charAt(i) == '+' ? 1 : -1);
                op = 0;
                num = 0;
            }
        }

        return pre + sign * curr;
    }
}
