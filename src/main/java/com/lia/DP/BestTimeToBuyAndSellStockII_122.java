package com.lia.DP;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 *
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * Created by liqu on 9/28/16.
 */
public class BestTimeToBuyAndSellStockII_122 {
    /*
    Since we can have as many transactions as we like, the key point is we need to consider every
    peak immediately following a valley to maximize the profit. In case we skip on of the peaks,
    we will end up losing the profit over one of the transactions leading to an overall lesser profit.

    Time Complexity: O(n)
    Space Complexity: O(1)
     */

    public int maxProfit(int[] prices) {
        int valley = prices[0], peak = prices[0];
        int max = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }

    /*
    Instead of looking for every peak following a valley, we can simply go on crawling over the slope
    and keep on adding the profit obtained from every consecutive transaction.
    We need not track the costs corresponding to the peaks and valleys along with the max profit,
    but we can directly keep on adding the difference between the consecutive numbers of the array
    if the second number is larger than the first one, and the total sum will be the max profit.
     */
    public int quickSolver(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
