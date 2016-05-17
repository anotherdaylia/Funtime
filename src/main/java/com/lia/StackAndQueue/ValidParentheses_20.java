package com.lia.StackAndQueue;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by liqu on 5/14/16.
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> brackets = new Stack<>();

        for (char c : chars) {
            if (c == 40 || c == 91 || c ==123) {
                brackets.push(c);
            } else {
                if (brackets.empty()) return false;
                char open = brackets.pop();
                if (c == 41 && open != 40) return false;
                if (c == 93 && open != 91) return false;
                if (c == 125 && open != 123) return false;
            }
        }

        return !brackets.empty();
    }
}
