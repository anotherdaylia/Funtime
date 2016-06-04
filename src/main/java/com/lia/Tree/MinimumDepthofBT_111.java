package com.lia.Tree;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 *
 * Created by liqu on 5/19/16.
 */
public class MinimumDepthofBT_111 {

    // DFS implementation
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return findLeaf(root, 1);
    }

    private int findLeaf(TreeNode node, int level) {
        if (node.left == null && node.right == null) return level;

        int leftDepth = Integer.MAX_VALUE, rightDepth = Integer.MAX_VALUE;
        if (node.left !=null) leftDepth = findLeaf(node.left, level + 1);
        if (node.right !=null) rightDepth = findLeaf(node.right, level + 1);

        return Math.min(leftDepth, rightDepth);
    }

    //BFS solution O(n) runtime, O(n) space
    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 1;
        TreeNode rightmost = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node == rightmost) {
                depth++;
                rightmost = (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }
}
