package cn.fireflying;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int plus2 = 0;
        int plus3 = 0;
        int plus5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; ) {
            int temp = 0;
            if (2 * dp[plus2] <= 3 * dp[plus3] && 2 * dp[plus2] <= 5 * dp[plus5]) {
                temp = 2 * dp[plus2++];
            } else if (3 * dp[plus3] <= 5 * dp[plus5]) {
                temp = 3 * dp[plus3++];
            } else {
                temp = 5 * dp[plus5++];
            }
            if (temp > max) {
                max = temp;
                dp[i++] = max;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
