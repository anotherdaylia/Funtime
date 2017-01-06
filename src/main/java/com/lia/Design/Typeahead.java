package com.lia.Design;
import java.util.*;

/**
 * Implement typeahead. Given a string and a dictionary, return all words that contains the string as a substring.
 * The dictionary will give at the initialize method and wont be changed.
 * The method to find all words with given substring would be called multiple times.
 *
 * Created by liqu on 10/29/16.
 */
public class Typeahead {
    private TrieNode root;

    // @param dict A dictionary of words dict
    public Typeahead(Set<String> dict) {
        this.root = new TrieNode();
        for (String word : dict) {
            insert(word);
        }
    }

    private void insert(String word){
        for (int i = 0; i < word.length(); i++) {
            insert(word, i);
        }
    }

    private void insert(String word, int index) {
        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            if (!node.words.contains(word)){
                node.words.add(word);
            }
        }
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) {
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return new ArrayList<String>();
            }
            node = node.children.get(c);
        }
        return node.words;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        List<String> words;
        public TrieNode() {
            this.children = new HashMap<>();
            this.words = new ArrayList<>();
        }
    }

}
