package com.lia.Graph;
import com.lia.Tree.TreeNode;

/**
 * The diameter of a tree T = (V,E) is given by max δ(u, v) (u,v)∈V
 * (where δ(u, v) is the number of edges on the path from u to v).
 * Describe an efficient algorithm to compute the diameter of a tree,
 * and show the correctness and analyze the running time of your algorithm.
 *
 * Created by liqu on 9/14/16.
 */
public class Diameter implements GraphReadable{

    public int getDiameter(TreeNode node) {
        // base case: if tree is empty
        if (node == null) return 0;

        // get the height of left and right subtrees
        int lheight = height(node.left);
        int rheight = height(node.right);

        // get the diameter of left and right subtrees
        int ldiameter = getDiameter(node.left);
        int rdiameter = getDiameter(node.right);

        /* Return max of following three
         1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 2, Math.max(ldiameter, rdiameter));
    }

    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    private int height(TreeNode node) {
        // base case tree is empty
        if (node == null) return 0;

        /* If tree is not empty then height = 1 + max of left height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
