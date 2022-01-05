package cn.fireflying;

import java.util.Arrays;

/**
 * @author: Fire Flying
 * @create: 2022-01-04 19:03
 **/

public class LeetCode122 {

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit1(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit1(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        if (prices.length < 1) {
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n - 1][0];
    }

}
