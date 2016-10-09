package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 * Created by liqu on 6/21/16.
 */
public class GenerateParen_22 {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        if (n < 1) return combinations;
        int open = n, close = n;
        generate(combinations, "(", open - 1, close);
        return combinations;
    }

    private void generate(List<String> combinations, String s, int open, int close) {
        if (open == 0 && close ==0) combinations.add(s);
        if (open > 0) generate(combinations, s + "(", open - 1, close);
        if (close > open) generate(combinations, s + ")", open, close - 1);
    }
}
