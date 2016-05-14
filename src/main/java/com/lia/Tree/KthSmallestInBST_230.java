package com.lia.Tree;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * Created by liqu on 5/10/16.
 */
public class KthSmallestInBST_230 {
    // 1. Binary Search Solution
    public int kthSmallest(TreeNode root, int k) {
        int count = counter(root.left);
        if (k <= count) return kthSmallest(root.left, k);
        else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        } else return root.val;
    }

    private int counter(TreeNode node) {
        if (node == null) return 0;
        else return 1 + counter(node.left) + counter(node.right);
    }

    // 2. DFS in-order solution
    int count = 0;
    int key = 0;
    public int kthSmallestDFS(TreeNode root, int k) {
        count = k;
        findKthNode(root);
        return key;
    }

    private void findKthNode(TreeNode node) {
        if (node.left != null) findKthNode(node.left);
        count--;
        if (count == 0) {
            key = node.val;
            return;
        }
        if (node.right != null) findKthNode(node.right);
    }

    // 3. DFS iterative solution
    // The inorder traversal of a BST is ascending order sorted
    public int kthSmallestStack(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) return node.val;
            TreeNode right = node.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
