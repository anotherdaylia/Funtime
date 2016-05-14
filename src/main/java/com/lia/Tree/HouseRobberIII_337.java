package com.lia.Tree;

/**
 * https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem
 *
 * Created by liqu on 5/13/16.
 */
public class HouseRobberIII_337 {
    // Sean's solution
    private static class Money {
        int withCurrentHouse;
        int withoutCurrentHose;
        Money(int w, int wo) {
            this.withCurrentHouse = w;
            this.withoutCurrentHose = wo;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        Money sum = robMoney(root);
        return Math.max(sum.withCurrentHouse, sum.withoutCurrentHose);
    }

    private Money robMoney(TreeNode house) {
        if (house == null) return new Money(0,0);

        Money left = robMoney(house.left);
        Money right = robMoney(house.right);

        int withCurrentHouse = house.val + left.withoutCurrentHose + right.withoutCurrentHose;
        int withoutCurrentHose = Math.max(left.withCurrentHouse, left.withoutCurrentHose)
                + Math.max(right.withCurrentHouse, right.withoutCurrentHose);
        return new Money(withCurrentHouse, withoutCurrentHose);
    }

    // exhaustive search solution
    public int robArr(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
