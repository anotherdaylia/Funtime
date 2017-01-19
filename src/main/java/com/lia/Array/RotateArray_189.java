package com.lia.Array;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this proble

 * Created by liqu on 3/20/16.
 */

import java.util.Arrays;
import java.util.LinkedList;

public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] aux = Arrays.copyOf(nums,nums.length);

        // O(N) space complexity
        // The real usable k is ( k % N )
        k = k % N;

        // O(N) time complexity
        for (int i = 0; i < k; i++) {
            nums[i] = aux[N - k + i];
        }

        for (int i = 0; i < N - k; i++) {
            nums[k + i] = aux[i];
        }
    }

    public void rotateInPlace(int[] nums, int k) {
        int N = nums.length;
        k = k % N;

        // O(k) space complexity
        int[] help = new int[k];
        for (int i = 0; i < k; i++) {
            help[i] = nums[N - k + i];
        }

        // O(N) time complexity
        for (int i = N - k - 1; i >= 0; i--) {
            exch(nums, i, i + k);
        }

        for (int i = 0; i < k; i++) {
            nums[i] = help[i];
        }
    }

    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void rotateDeck(int[] nums, int k) {
        LinkedList<Integer> deck = new LinkedList<>();

        for (int i : nums){
            deck.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            deck.addFirst(deck.removeLast());
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = deck.remove();
        }
    }

    // O(1) space complexity - in place
    // O(N) time complexity
    public void rotateWithFlip(int[] nums, int k) {
        if (nums == null || nums.length ==0 || k == 0) return;
        int n = nums.length;
        k = k % n;
        flip(nums, 0, n-k-1);
        flip(nums, n-k,  n-1);
        flip(nums, 0, n-1);
    }

    private void flip (int[] nums, int lo, int hi) {
        while (lo < hi){
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }

    }

}
