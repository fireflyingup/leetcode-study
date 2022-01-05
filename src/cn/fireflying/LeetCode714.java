package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-05 21:33
 **/

public class LeetCode714 {

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit1(new int[]{1,3,7,5,10,3}, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][0];
    }

    public static int maxProfit1(int[] prices, int fee) {
        int coin = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = Math.max(buy + prices[i] - fee, coin);
            buy = Math.max(coin - prices[i], buy);
            coin = temp;
        }
        return coin;
    }
}
