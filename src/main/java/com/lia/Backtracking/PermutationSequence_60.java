package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 * Created by liqu on 10/4/16.
 */
public class PermutationSequence_60 {

    /*
    nums is the remaining number (initialized with 1 ~ 9) that have not been used.

    For each n, there are n group of (n-1)! permutations.
    We save the number of permutations at each level in fact[].

    for i from n - 1 -> 0
        k / fact[n] is the index of the number should be used at string.charAt(n - i)  - the kth group
        k % fact[n] is the remaining number of permutation that need to be worked out
     */
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i * fact[i - 1];

        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(nums.get(index));
            nums.remove(index);
        }
        return sb.toString();
    }

}
