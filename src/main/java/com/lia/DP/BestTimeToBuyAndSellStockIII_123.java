package com.lia.DP;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Created by liqu on 9/29/16.
 */
public class BestTimeToBuyAndSellStockIII_123 {

    /*
    We have to sell after we buy, and we have to buy the second time after we sell the first time.
    buy[i] = max(buy[i - 1], sell[i - 1] - prices[i]);
    sell[i] = max(sell[i - 1], buy[i - 1] + prices[i]);
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}
