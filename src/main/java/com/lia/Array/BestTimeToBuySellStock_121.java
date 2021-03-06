package com.lia.Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.

 * Created by liqu on 7/14/16.
 */
public class BestTimeToBuySellStock_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int profit = 0, buy = 0, sell = 1;
        while(sell < prices.length) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
            } else {
                profit = Math.max(profit, prices[sell] - prices[buy]);
            }
            sell++;
        }
        return profit;
    }

    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int low = prices[0], profit = 0;
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - low;
            if (diff > profit) profit = diff;
            if (prices[i] < low) low = prices[i];
        }
        return profit;
    }
}
