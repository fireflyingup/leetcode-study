package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-26 21:06
 **/

public class LeetCode55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{0}));
    }


    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(dp[i - 1], nums[i] + i);
            } else {
                break;
            }
        }
        return dp[length - 1] >= length - 1;
    }
}
