package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-06 22:05
 **/

public class LeetCode413 {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 10, 15}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
                dp[i] = dp[i - 1] + count;
            } else {
                count = 0;
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }
}
