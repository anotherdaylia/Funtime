package com.lia.DivideAndConquer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the
 * kth largest element in the sorted order, not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * Created by liqu on 6/12/16.
 */
public class KthLargestEleInAnArr_215 {

    // 1. Sort solution Time: O(NlogN) + Space O(1)
    public int findKthLargestSort(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    /*
    2. PriorityQueue (heap) solution.  Time: O(NlogK) + Space: O(K)
    Use a min oriented priority queue that will store the K-th largest values.
    The algorithm iterates over the whole input and maintains the size of priority queue.
     */
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /*
     3. QuickSelect Solution. Time: O(N) ~ O(N^2) + Space: O(1)
     The smart approach for this problem is to use the selection algorithm
     (based on the partion method - the same one as used in quicksort).
     */

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k);
        return nums[p];
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        int i = lo + 1, j = hi;
        int v = nums[lo];

        while (lo < hi) {
            while (nums[i] <= v) {// find item on lo to swap
                i++;
                if (i >= hi) break;
            }

            while (nums[j] >= v) { // find item on hi to swap
                j--;
                if (j <= lo) break;
            }

            if (i >= j) break; // check if pointers cross
            exch(nums, i, j);
        }

        exch(nums, lo, j); // put partitioning item v at a[j]

        if      (k > j) return quickSelect(nums, j + 1, hi, k);
        else if (k < j) return quickSelect(nums, lo, j - 1, k);
        else return j;
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
