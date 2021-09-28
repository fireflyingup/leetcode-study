package cn.fireflying.leetcode_389;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * 
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(findTheDifference3("abcd", "abcde"));
    }

    /**
     * 排序 比较差异
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]) {
                return chars1[i];
            }
        }
        return chars1[chars1.length - 1];
    }

    /**
     * 位运算
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference1(String s, String t) {
        char str = 0;
        for (char c: s.toCharArray()) {
            str ^= c;
        }
        for (char c : t.toCharArray()) {
            str ^= c;
        }
        return str;
    }

    /**
     * 计数
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        // 小写字母26个
        int[] chars = new int[26];
        for (char c: s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            int i = --chars[c - 'a'];
            if (i < 0) {
                return c;
            }
        }
        return 'a';
    }

    /**
     * 计数
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference3(String s, String t) {
        char a = 0;
        char b = 0;
        for (char c : s.toCharArray()) {
            a += c;
        }
        for (char c : t.toCharArray()) {
            b += c;
        }
        return (char)(b - a);
    }
}
