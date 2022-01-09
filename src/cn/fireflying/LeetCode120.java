package cn.fireflying;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Fire Flying
 * @create: 2022-01-09 21:21
 **/

public class LeetCode120 {

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        integerList.add(2);
        list.add(integerList);

        integerList = new LinkedList<>();
        integerList.add(3);
        integerList.add(4);
        list.add(integerList);

        integerList = new LinkedList<>();
        integerList.add(6);
        integerList.add(5);
        integerList.add(7);
        list.add(integerList);

        integerList = new LinkedList<>();
        integerList.add(4);
        integerList.add(1);
        integerList.add(8);
        integerList.add(3);
        list.add(integerList);

        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp = new int[length];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
