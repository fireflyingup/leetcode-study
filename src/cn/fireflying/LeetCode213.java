package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-23 22:03
 **/

/**
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 */
public class LeetCode213 {

    public static void main(String[] args) {
        System.out.println(rob1(new int[]{2,3,2}));
        System.out.println(rob1(new int[]{1,2,3,1}));
        System.out.println(rob1(new int[]{1,2,3}));
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 2];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i + 2] = Math.max(dp[i - 1], dp[i]) + nums[i];
        }
        
        return Math.max(dp[length], dp[length + 1]);
    }

    public static int rob1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(find(nums, 0, length - 1), find(nums, 1, length));
    }

    private static int find(int[] nums, int start, int end) {
        int left = 0;
        int right = 0;
        for (int i = start; i < end; i++) {
            int temp = Math.max(left + nums[i], right);
            left = right;
            right = temp;
        }
        return right;
    }
}
