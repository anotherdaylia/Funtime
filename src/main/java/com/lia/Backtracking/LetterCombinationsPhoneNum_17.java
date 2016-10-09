package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 * Created by liqu on 6/21/16.
 */
public class LetterCombinationsPhoneNum_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() < 1) return result;
        String[] buttons = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combine(buttons, result, digits.toCharArray(), new StringBuilder(), 0, 0);
        return result;
    }

    private void combine(String[] buttons, List<String> result, char[] digits, StringBuilder sb, int d, int start) {
        if (d == digits.length) {
            result.add(sb.toString());
            return;
        }

        char[] letters = buttons[digits[d] - '0'].toCharArray();
        for (int i = 0; i < letters.length; i++) {
            sb.append(letters[i]);
            combine(buttons, result, digits, sb, d+1, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
