package cn.fireflying.leetcode_70;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */


public class Solution {

    public static void main(String[] args) {
        test(20);
    }

    public static void test (int n) {
        System.out.println(climbStairs1(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
        System.out.println(climbStairs4(n));
    }

    /**
     * 递归 （超时）
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 动态规划 + 数组
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arrs = new int[n];
        arrs[0] = 1;
        arrs[1] = 2;
        for (int i = 2; i < arrs.length; i++) {
            arrs[i] = arrs[i - 1] + arrs[i - 2];
        }
        return arrs[n - 1];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int res = 3;
        for (int i = 2; i < n; i++) {
            res = a + b;
            a= b;
            b = res;
        }
        return res;
    }

    /**
     * 斐波那契
     *
     */
    public static int climbStairs4(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }

}
