package com.lia.Design;

import com.lia.Tries.*;

import java.util.Map;

/**
 * Created by liqu on 10/29/16.
 */
//public class TrieSerialization {
//    /**
//     * This method will be invoked first, you should design your own algorithm
//     * to serialize a trie which denote by a root node to a string which
//     * can be easily deserialized by your own "deserialize" method later.
//     */
//    public String serialize(com.lia.Tries.TrieNode root) {
//        StringBuilder sb = new StringBuilder();
//        serialize(root, sb);
//        return sb.toString();
//    }
//
//    private void serialize(com.lia.Tries.TrieNode node, StringBuilder sb) {
//        sb.append("<");
//        for (Map.Entry<Character, com.lia.Tries.TrieNode> entry : node.children.entrySet()) {
//            sb.append(entry.getKey());
//            serialize(entry.getValue(), sb);
//        }
//        sb.append(">");
//    }
//
//    /**
//     * This method will be invoked second, the argument data is what exactly
//     * you serialized at method "serialize", that means the data is not given by
//     * system, it's given by your own serialize method. So the format of data is
//     * designed by yourself, and deserialize it here as you serialize it in
//     * "serialize" method.
//     */
//    int index = 0;
//    public com.lia.Tries.TrieNode deserialize(String data) {
//        com.lia.Tries.TrieNode root = new com.lia.Tries.TrieNode();
//        deserialize(root, data);
//        return root;
//    }
//
//    private void deserialize(com.lia.Tries.TrieNode node, String data) {
//        index++;
//        //System.out.println(index);
//        while (true) {
//            char c = data.charAt(index);
//            if (Character.isLetter(c)) {
//                node.children.put(c, new com.lia.Tries.TrieNode());
//                //if (index >= data.length()) return;
//                index++;
//                deserialize(node.children.get(c), data);
//            } else if (c == '>') {
//                index++;
//                break;
//            }
//        }
//    }
//}
