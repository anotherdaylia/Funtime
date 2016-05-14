package com.lia.Tree;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * Created by liqu on 5/12/16.
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null) {
            if (left.val != right.val) return false;
            return isSymmetric(left.left, right.right) & isSymmetric(left.right, right.left);
        } else return false;
    }

    public boolean isSymmetricStack(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();

        if (root.left != null) {
            if (root.right == null) return false;
            else {
                stack.push(root.left);
                stack.push(root.right);
            }
        } else {
            if (root.right != null) return false;
        }

        TreeNode left, right;
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();

            // check left and right value
            if (left.val != right.val) return false;

            // go to left.left vs right.right
            if (left.left != null) {
                if (right.right == null) return false;
                else {
                    stack.push(left.left);
                    stack.push(right.right);
                }
            } else {
                if (right.right != null) return false;
            }

            // go to left.right vs right.left
            if (left.right != null) {
                if (right.left == null) return false;
                else {
                    stack.push(left.right);
                    stack.push(right.left);
                }
            } else {
                if (right.left != null) return false;
            }
        }
        return true;
    }
}
