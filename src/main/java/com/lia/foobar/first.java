package com.lia.foobar;

import java.util.Stack;

/**
 * Created by liqu on 6/2/16.
 */
public class First {

    public static String answer(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> operator = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '*') {
                operator.push('*');
            } else {
                while (!operator.empty() && operator.peek() == '*') {
                    sb.append(operator.pop());
                }
                operator.push(c);
            }
        }
        while (!operator.empty()) sb.append(operator.pop());

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "2*4+9*3";

        First first = new First();
        System.out.println(first.answer(input));

    }
}
