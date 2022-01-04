package cn.fireflying;


/**
 * @author: Fire Flying
 * @create: 2022-01-03 22:37
 **/

public class LeetCode1014 {

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,10,7}));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int length = values.length;
//        int[] dp = new int[length];
        int iMax = values[0];
        int temp = 0;
        int max = values[1] + values[0] - 1;
        for (int i = 1; i < length; i++) {
            int r = values[i] + i;
            max = Math.max(max, values[i] + values[temp] + temp - i);
            if (iMax < r) {
                iMax = r;
                temp = i;
            }
        }
        return max;
    }
}
