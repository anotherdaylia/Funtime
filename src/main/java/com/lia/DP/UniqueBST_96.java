package com.lia.DP;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * Created by liqu on 7/14/16.
 */
public class UniqueBST_96 {
    /*
    G(n) = the number of unique BSTs for sequence of length n
    f(i, n) = the number of unique BSTs where the number i is the root of BST, and the sequence ranges from 1 to n.

    G(n) = f(1, n) + ... + f(n, n)
    The total number of unique BST G(n), is the sum of BST f(i) using each number i as a root.

    f(i, n) = G(i-1) * G(n-1)
    f(i, n) is the cartesian product of G(i-1) and G(n-i).
    (i-1) of nodes will be on the left of root i, and (n-i) of nodes will be on the right of root i.
    Don't need to care about what numbers n-i ~ n are, the number of unique BST structures for sequence of length (n-i) is the same

    So: G(n) = G(0) * G(n-1) + ... + G(n-1) * G(0)
    Above forms a recursion.
    Construct from botton forms a dynamic programming, because higher number will depend on lower numbers.
    */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
