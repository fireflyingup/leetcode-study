package cn.fireflying.leetcode_49;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i]仅包含小写字母
 *
 */

public class Solution {

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        for (List<String> strings : list) {
            System.out.println(strings);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);
            String s = new String(bytes);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new LinkedList(map.values());
    }
}
