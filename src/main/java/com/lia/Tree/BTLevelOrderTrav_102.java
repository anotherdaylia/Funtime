package com.lia.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liqu on 5/17/16.
 */
public class BTLevelOrderTrav_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        travel(root, result, level);
        return result;
    }

    private void travel(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        List<Integer> list = result.get(level);
        list.add(node.val);

        travel(node.left, result, level + 1);
        travel(node.right, result, level + 1);
    }

    // BFS solution
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;
        result.add(new ArrayList<>());
        result.get(0).add(root.val);

        queue.add(root);
        TreeNode rightmost = root;
        ArrayList<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                level.add(node.left.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                level.add(node.right.val);
            }
            if (node == rightmost && !queue.isEmpty()) {
                rightmost = queue.peekLast();
                result.add(level);
                level = new ArrayList<>();
            }
        }

        return result;
    }
}
