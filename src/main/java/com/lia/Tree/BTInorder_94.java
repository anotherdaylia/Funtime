package com.lia.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Inorder: left, root, right
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Created by liqu on 5/9/16.
 */
public class BTInorder_94 {
    // Recursive DFS solution
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private List<Integer> inorder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
        return list;
    }

    // Iterative solution - imitate recursive function calls
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            TreeNode right = node.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return list;
    }
}
