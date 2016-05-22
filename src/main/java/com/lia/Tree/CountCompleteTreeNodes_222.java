package com.lia.Tree;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Created by liqu on 5/21/16.
 */
public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {

        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if (leftDepth == rightDepth)
            return numOfNodes(leftDepth);
        else
            return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private int numOfNodes(int depth) {
        // int count = 1;
        // for(int i = 1; i <= height; i++) { count *= 2; }
        // return count - 1;

        // equivelance to above code
        return (1 << depth) - 1;
    }

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }
}
