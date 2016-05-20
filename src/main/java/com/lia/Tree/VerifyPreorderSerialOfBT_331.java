package com.lia.Tree;

import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
 * we record the node's value. If it is a null node, we record using a sentinel value such as #.
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 * where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal
 * serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid,
 * for example it could never contain two consecutive commas such as "1,,3".

 Example 1:
 "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Return true

 Example 2:
 "1,#"
 Return false

 Example 3:
 "9,#,#,1"
 Return false

 * Created by liqu on 5/14/16.
 */
public class VerifyPreorderSerialOfBT_331 {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        boolean isEnd = false;
        int i = 0;
        while(i < nodes.length) {
            String cur = nodes[i++];
            if(isEnd) return false;
            if (cur.equals("#")) {
                if (stack.empty()) isEnd = true;
                else stack.pop();
            } else {
                stack.push(cur);
            }
        }
        // System.out.println(stack.size());
        // System.out.println(isEnd);
        return stack.empty() && isEnd;
    }
}
