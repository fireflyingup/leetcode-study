package cn.fireflying.leetcode_5;

/**
 * @program: leetcode-study
 * @author: Fire Flying
 * @create: 2021-10-03 09:56
 **/

import java.util.Arrays;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 */

public class Solution {

    public static void main(String[] args) {
        // bc9cb
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLength = 0;
        int leftIndex = 0;

        char[] chars = s.toCharArray();

        for (int i = 2; i <= length; i++) {
            for (int left = 0; left < length; left++) {
                int right = i + left - 1;
                if (right > length - 1) {
                    break;
                }

                if (chars[left] != chars[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] && right - left > maxLength) {
                    maxLength = right - left;
                    leftIndex = left;
                }

            }
        }


        return s.substring(leftIndex, leftIndex + maxLength + 1);
    }

}
