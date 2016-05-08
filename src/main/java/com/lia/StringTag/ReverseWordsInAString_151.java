package com.lia.StringTag;

/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 *
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 *
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 * Created by liqu on 5/7/16.
 */
public class ReverseWordsInAString_151 {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        if (words.length == 1 || words[0] == "") return s;

        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            // for avoid the tailing space after the last word
            if(i == 0) {
                sb.append(words[i]);
                break;
            }
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        reverseWords("a");
    }
}
