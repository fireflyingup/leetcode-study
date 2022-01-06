package cn.fireflying;

import java.util.*;

/**
 * @author: Fire Flying
 * @create: 2022-01-05 23:34
 **/

public class LeetCode139 {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));
        list = new LinkedList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(wordBreak("applepenapple", list));
        list = new LinkedList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wordBreak("catsandog", list));
        list = new LinkedList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        list.add("aaaaa");
        list.add("aaaaaa");
        list.add("aaaaaaa");
        list.add("aaaaaaaa");
        list.add("aaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", list));

    }

    /**
     * 步骤：
     * 1、取出wordDict的最大长度max和最小长度min
     * 2、讲wordDict放入map里面存储，因为hash相对于map来说更快
     * 3、对一个点（i）来说，当i满足当前是0或者dp[i]为true，并且i 到 （i+min -> i+max）中存在于map里面的字符的话，那就讲当前位置标志为true。
     * 如果最后一个为true则表示可以到达
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
            min = Math.min(min, s1.length());
            map.put(s1, true);
        }
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        for (int i = 0; i < length; i++) {
            // 从i+min 到 i+max 便利
            for (int j = i + min; j <= i + max && j <= length; j++) {
                // 是开头字符串 或者 前面可达的 并且包含当前字符串的话 标志j为true
                if ((i == 0 || dp[i]) && map.containsKey(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[length];
    }

}
