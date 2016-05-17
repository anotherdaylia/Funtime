package com.lia.StackAndQueue;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Created by liqu on 5/16/16.
 */
public class EvaluateRevPolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                numbers.push(numbers.pop() + numbers.pop());
            } else if (s.equals("-")) {
                numbers.push(-numbers.pop() + numbers.pop());
            } else if (s.equals("*")) {
                numbers.push(numbers.pop() * numbers.pop());
            } else if (s.equals("/")) {
                int a = numbers.pop();
                int b = numbers.pop();
                numbers.push(b / a);
            } else {
                numbers.push(Integer.valueOf(s));
            }
        }
        return numbers.pop();
    }
}
