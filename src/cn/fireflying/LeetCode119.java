package cn.fireflying;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Fire Flying
 * @create: 2022-01-09 01:32
 **/

public class LeetCode119 {

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        for (int i : dp) {
            if (i > 0) {
                list.add(i);
            }
        }
        return list;
    }
}
