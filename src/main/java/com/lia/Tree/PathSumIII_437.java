package com.lia.Tree;

/**
 * You are given a binary tree in which each node contains an integer value.
 Find the number of paths that sum to a given value.
 The path does not need to start or end at the root or a leaf, but it must go downwards
 (traveling only from parent nodes to child nodes).
 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:
 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

       10
      /  \
     5   -3
    / \    \
   3   2   11
  / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11

 * Created by liqu on 1/2/17.
 */
public class PathSumIII_437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)  return 0;
        int count = 0;
        count += getPathSum(root, sum);
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        return count;
    }

    // get path sum rooted at node
    private int getPathSum(TreeNode node, int sum){
        int count = 0;
        // found a sum
        if (node.val == sum) count++;

        // continue search until null, because even found, there still are path sum to "sum".
        if (node.left != null) {
            count += getPathSum(node.left, sum - node.val);
        }
        if (node.right != null) {
            count += getPathSum(node.right, sum - node.val);
        }
        return count;
    }
}
