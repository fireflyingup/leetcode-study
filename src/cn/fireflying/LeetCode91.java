package cn.fireflying;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 */
public class LeetCode91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < 27; i++) {
            map.put(String.valueOf(i), true);
        }
        int count = 1;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if (map.containsKey(s.substring(i - 1, i))) {
                count++;
            } else if (s.substring(i - 1, i).equals("00")) {
                return 0;
            }
        }
        return count;
    }
}
