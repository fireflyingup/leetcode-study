package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-09 22:44
 **/

public class LeetCode63 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][] {
                {0,0,0},{0,1,0},{0,0,0}
        }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLength = obstacleGrid.length;
        int yLength = obstacleGrid[0].length;
        int[][] dp = new int[xLength][yLength];
        boolean hasStone = false;
        for (int i = 0; i < xLength; i++) {
            if (obstacleGrid[i][0] == 1 || hasStone) {
                hasStone = true;
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        hasStone = false;
        for (int i = 0; i < yLength; i++) {
            if (obstacleGrid[0][i] == 1 || hasStone) {
                hasStone = true;
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < xLength; i++) {
            for (int j = 1; j < yLength; j++) {
                if (obstacleGrid[i - 1][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[xLength - 1][yLength - 1];
    }
}
