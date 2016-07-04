package com.lia.Tries;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * Created by liqu on 6/13/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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
        x.next[c-97] = insert(x.next[c-97], word, d + 1);
        return x;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode x = search(root, word, 0);
        if (x == null || !x.val) return false;
        else return true;
    }

    private TrieNode search(TrieNode x, String word, int d) {
        if (x == null) return null;
        if (d == word.length()) return x;
        char c = word.charAt(d);
        return search(x.next[c-97], word, d + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode x = search(root, prefix, 0);
        return x != null;
        //return checkPrefix(x);
    }

    private boolean checkPrefix(TrieNode x) {
        if (x == null) return false;
        for (int i = 0; i < 26; i++) {
            if (x.next[i] != null) return true;
        }
        return false;
    }

}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
