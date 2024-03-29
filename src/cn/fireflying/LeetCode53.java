package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-29 21:27
 **/

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *  
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray1(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int max = nums[0];
        dp[0] = max;
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int x = nums[0];
        for (int i = 1; i < length; i++) {
            x = Math.max(nums[i], x + nums[i]);
            max = Math.max(max, x);
        }
        return max;
    }
}
