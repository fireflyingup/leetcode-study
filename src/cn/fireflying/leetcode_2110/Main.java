package cn.fireflying.leetcode_2110;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class Main {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String temp;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            temp = new String(chars);
            if (!map.containsKey(temp)) {
                map.put(temp, new LinkedList<>());
            }
            map.get(temp).add(str);
        }
        List<List<String>> list = new LinkedList<>(map.values());

        return list;
    }

}
