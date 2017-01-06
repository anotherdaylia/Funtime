package com.lia.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liqu on 5/17/16.
 */
public class BTRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue1.size() > 0) result.add(queue1.get(0).val);
            while(!queue1.isEmpty()) {
                TreeNode cur = queue1.removeFirst();
                if (cur.right != null) queue2.add(cur.right);
                if (cur.left != null) queue2.add(cur.left);
            }
            if (queue2.size() > 0) result.add(queue2.get(0).val);
            while(!queue2.isEmpty()) {
                TreeNode cur = queue2.removeFirst();
                if (cur.right != null) queue1.add(cur.right);
                if (cur.left != null) queue1.add(cur.left);
            }
        }
        return result;
    }

    /*
    11/11/16
     */
    public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode rightmost = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node == rightmost) {
                result.add(node.val);
                if (queue.size() > 0) {
                    rightmost = queue.get(queue.size() - 1);
                }
            }
        }
        return result;
    }
}
