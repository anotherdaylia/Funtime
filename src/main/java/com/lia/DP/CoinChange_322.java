package com.lia.DP;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Created by liqu on 9/26/16.
 */
public class CoinChange_322 {
    /*
    if I take that coin into account, then the fewest number of coins we can get is
    1+coinChange(amount-that_coin_value).
    So for all the coins, we return the smallest number as
    min(1+coinChange(amount-coin1_value), 1+coinChange(amount-coin2_value, ......).

    Lesson learned: the cached element is not necessarily the exact prev element.
    The key is to find the recurrence relationship.
    */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] cache = new int[amount + 1];

        for (int num = 1; num <= amount; num++) {
            int min = -1;
            for (int coin : coins) {
                if (num >= coin && cache[num - coin] != -1){
                    int temp = cache[num - coin] + 1;
                    if (min < 0) min = temp;
                    else min = Math.min(min, temp);
                }
            }
            cache[num] = min;
        }
        return cache[amount];
    }
}
