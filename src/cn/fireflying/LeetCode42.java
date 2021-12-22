package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-21 22:25
 **/

import java.util.Arrays;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 */
public class LeetCode42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{2,0,2}));
    }

    public static int trap(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }

        int maxLeft = -1;
        int finalInt = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            } else {
                int right = 0;
                int maxRight = -1;
                for (int j = i; j < length; j++) {
                    if (height[j] > maxRight) {
                        maxRight = height[j];
                        right = j;
                    }
                    if (maxRight > maxLeft) {
                        break;
                    }
                }
                int min = Math.min(maxLeft, maxRight);
                while (right > i) {
                    finalInt += min - height[i];
                    i++;
                }
                maxLeft = maxRight;
            }
        }
        return finalInt;
    }


}