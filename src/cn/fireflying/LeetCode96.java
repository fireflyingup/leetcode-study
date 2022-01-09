package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-07 12:50
 **/

/**
 * TODO
 */
public class LeetCode96 {

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

    public static int numTrees(int n) {

        if (n == 1) {
            return 1;
        }
        int sum = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = result + i;
            sum += result;
        }
        return sum - n + 1;
    }
}
