package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-01 19:04
 **/

public class LeetCode1567 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-1, 2}));
        System.out.println(maxProduct(new int[]{1,2,3,5,-6,4,0,10}));
    }

    public static int maxProduct(int[] nums) {
        int max = 0;
        int positive = 0;
        int negative = 0;
        for (int num : nums) {
            if (num > 0) {
                positive++;
                negative = negative > 0 ? negative + 1: 0;
            } else if (num < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}
