package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-21 20:33
 **/

/**
 * 泰波那契序列Tn定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 * 
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即answer <= 2^31 - 1。
 *
 */

public class Leetcode1137 {

    public static void main(String[] args) {
        System.out.println(tribonacci(3));
        System.out.println(tribonacci1(3));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int i = 0;
        int j = 1;
        int m = 1;
        int sum = 0;
        for (int k = 3; k <= n; k++) {
            sum = i + j + m;
            i = j;
            j = m;
            m = sum;
        }
        return sum;
    }

    public static int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] target = new int[n + 1];
        target[0] = 0;
        target[1] = 1;
        target[2] = 1;
        for (int i = 3; i <= n; i++) {
            target[i] = target[i - 3] + target[i - 2] + target[i - 1];
        }
        return target[n];
    }
}
