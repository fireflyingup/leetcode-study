package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-09 17:54
 **/

public class LeetCode931 {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}}));
    }

    /**
     * 自顶而下 据说还有自下而上的
     * @param matrix
     * @return
     */
    public static int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[0][i] = matrix[0][i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temp;
                if (j == 0) {
                    temp = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == length - 1){
                    temp = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    temp = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    temp = Math.min(dp[i - 1][j + 1], temp);
                }
                dp[i][j] = temp + matrix[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            min = Math.min(min, dp[length - 1][i]);
        }
        return min;
    }
}
