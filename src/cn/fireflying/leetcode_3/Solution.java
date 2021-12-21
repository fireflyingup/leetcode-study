package cn.fireflying.leetcode_3;

/**
 * @author: Fire Flying
 * @create: 2021-12-15 21:33
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int length = s.length();
        int temp = 0;
        int j = 0;
        set.add(s.charAt(0));
        for (int i = 0; i < length; i++) {
            while (++j < length && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                temp = j;
            }
            result = Math.max(result, temp - i + 1);
            set.remove(s.charAt(i));
            j--;
        }
        return result;
    }
}
