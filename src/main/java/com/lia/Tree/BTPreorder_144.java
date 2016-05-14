package com.lia.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Preorder: root, left, right.
 *
 * Created by liqu on 5/9/16.
 */
public class BTPreorder_144 {
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private List<Integer> preorder(TreeNode node, List<Integer> list) {
        if (node == null) return list;

        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
        return list;
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while(root != null){
            stack.push(root);
            list.add(root.val);
            root = root.left;
        }

        while(!stack.empty()) {
            TreeNode node = stack.pop().right;
            while (node != null) {
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return list;
    }
}

















