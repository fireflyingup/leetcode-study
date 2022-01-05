package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-04 18:53
 **/

public class LeetCode121 {

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit1(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int left = prices[0];
        int right = prices[0];
        for (int price : prices) {
            if (price < left) {
                left = price;
                right = price;
            }
            if (price > right) {
                right = price;
                max = Math.max(max, right - left);
            }
        }
        return max;
    }

    public static int maxProfit1(int[] prices) {
        int max = 0;
        int left = prices[0];
        for (int price : prices) {
            if (left > price) {
                left = price;
            } else if (price - left > max) {
                max = price - left;
            }
        }
        return max;
    }
}
