package cn.fireflying;

import java.util.Arrays;

/**
 * @author: Fire Flying
 * @create: 2022-01-09 23:16
 **/

public class LeetCode64 {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    public static int minPathSum(int[][] grid) {
        int xLength = grid.length;
        int yLength = grid[0].length;
        int[] dp = new int[yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[j] = grid[i][j];
                    } else {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                } else if (j == 0){
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[yLength - 1];
    }
}
