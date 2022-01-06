package cn.fireflying;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1352));
    }

    public static int nthUglyNumber(int n) {
        int count = 1;
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        int i = 1;
        while (count < n) {
            i++;
            if (i % 2 == 0 && null != map.get(i / 2)) {
                map.put(i, true);
                count++;
            } else if (i % 3 == 0 && null != map.get(i / 3)) {
                map.put(i, true);
                count++;
            } else if (i % 5 == 0 && null != map.get(i / 5)) {
                map.put(i, true);
                count++;
            }
        }
        return i;
    }
}
