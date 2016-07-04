package com.lia.Tries;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 * Created by liqu on 6/13/16.
 */
public class WordDictionary {
     private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    private void addWord(String word) {
        if (word == null || word.length() == 0) return;
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        if (d == word.length()) {
            x.val = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c-'a'] = insert(x.next[c-'a'], word, d+1);
        return x;
    }

    // Iterative solution for adding word
    private void addWordIterative(String word) {
        TrieNode x = root;
        for (char c : word.toCharArray()) {
            if (x.next[c-'a'] == null) {
                x.next[c-'a'] = new TrieNode();
            }
            x = x.next[c-'a'];
        }
        x.val = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(TrieNode x, String word, int d) {
        if (x == null) return false;
        if (d == word.length()) return x.val;

        char c = word.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < x.next.length; ch++) {
                if (x.next[ch] != null) {
                    if (match(x.next[ch], word, d + 1)) {
                        return true;
                    }
                }
            }
        } else return match(x.next[c-'a'], word, d + 1);
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("a");
        System.out.println(dic.search(".a"));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
