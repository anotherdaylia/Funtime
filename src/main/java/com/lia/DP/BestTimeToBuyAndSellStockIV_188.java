package com.lia.DP;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Created by liqu on 9/29/16.
 */
public class BestTimeToBuyAndSellStockIV_188 {
    /*
    If the number of transactions (k) is greater than half the length of the days,
    then it means you can do as many transactions (buy + sell) as you like.
    This is the same as question [Best Time to Buy and Sell Stock II].

    if (k < n/2), then work this question as a general case of question
    [Best Time to Buy and Sell Stock III].
     */

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) return quickSolve(prices, n);
        /*
        trans[0][k] is the kth buy
        trans[1][k] is the kth sell
        */
        int[][] trans = new int[2][k + 1];

        for (int i = 1; i <= k; i++) {
            trans[0][i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                trans[1][i] = Math.max(trans[1][i], trans[0][i] + price);
                trans[0][i] = Math.max(trans[0][i], trans[1][i - 1] - price);
            }
        }
        return trans[1][k];
    }

    private int quickSolve(int[] prices, int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
