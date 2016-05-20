package com.lia.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:
 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 * Created by liqu on 5/19/16.
 */
public class BTPaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;

        findLeaf(root, list, "");
        return list;
    }

    private void findLeaf(TreeNode node, List<String> list, String s) {
        if (s.equals("")) s = String.valueOf(node.val);
        else s += "->" + node.val;
        if (node.left == null && node.right == null) list.add(s);

        if (node.left != null) findLeaf(node.left, list, s);
        if (node.right != null) findLeaf(node.right, list, s);
    }
}
