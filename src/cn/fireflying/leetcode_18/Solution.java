package cn.fireflying.leetcode_18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 * 
 *
 * 提示：
 *
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private static void addList(List<List<Integer>> lists, int a, int b, int c, int d) {
        List<Integer> list = new LinkedList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        lists.add(list);
    }

    /**
     * 双重for + 双指针
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        addList(lists, nums[i], nums[j], nums[left], nums[right]);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return lists;
    }


}
