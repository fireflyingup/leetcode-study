package cn.fireflying;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Fire Flying
 * @create: 2022-01-09 01:09
 **/

public class LeetCode118 {


    public static void main(String[] args) {
        System.out.println(generate(1));
    }

    public static List<List<Integer>> generate(int numRows) {
        int[] dp = new int[numRows + 1];
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list1 = new LinkedList<>();
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
                list1.add(dp[j]);
            }
            System.out.println(Arrays.toString(dp));
            list.add(list1);
        }
        return list;
    }
}
