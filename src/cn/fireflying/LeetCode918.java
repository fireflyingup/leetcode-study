package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-29 22:25
 **/


public class LeetCode918 {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubarraySumCircular(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2})); //3
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5})); //10
        System.out.println(maxSubarraySumCircular(new int[]{3,-1,2,-1})); //4
        System.out.println(maxSubarraySumCircular(new int[]{3,-2,2,-3})); //3
        System.out.println(maxSubarraySumCircular(new int[]{-2,-3,-1})); //-1
        System.out.println(maxSubarraySumCircular(new int[]{-2,2,-2,9})); //9
        System.out.println(maxSubarraySumCircular(new int[]{-5,3,5})); //8
        System.out.println(maxSubarraySumCircular(new int[]{0,5,8,-9,9,-7,3,-2})); //8
        System.out.println(maxSubarraySumCircular(new int[]{88,-35,50,-38,-60,-31,-2,-8,-8,91,-14,50,-25,-26,1,71,-91,-64,-40,46,30,-97,9,-55,-36,-75,71,99,90,-53,-68,-20,-73,89,-14,74,-8,72,82,48,45,2,-42,12,77,22,87,56,73,-21,78,15,-6,-75,24,46,-11,-70,-90,-77,57,43,-66,10,-30,-47,91,-37,-4,-67,-88,19,66,29,86,97,-4,67,54,-92,-54,71,-42,-17,57,-91,-9,-15,-26,56,-57,-58,-72,91,-55,35,-20,29,51,70})); //8

    }

    public static int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int maxTemp = 0;
        int max = Integer.MIN_VALUE;
        int minTemp = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            maxTemp = Math.max(num, maxTemp + num);
            max = Math.max(maxTemp, max);
            minTemp = Math.min(num, minTemp + num);
            min = Math.min(minTemp, min);
            sum+=num;
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }

    /**
     * 这里的思路是找出最小点， 但是发现找不到最小点，找到了就等于你也能找到最大点了
     * @param nums
     * @return
     */
    public static int maxSubarraySumCircular1(int[] nums) {
        int length = nums.length;
        int minIndex = findMin(nums);
        int max = nums[minIndex];
        int temp = nums[minIndex];
        for (int i = minIndex + 1; i < length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            max = Math.max(temp, max);
        }
        for (int i = 0; i < minIndex; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            max = Math.max(temp, max);
        }
        return max;
    }

    public static int findMin(int[] nums) {
        int length = nums.length;
        int min = nums[0];
        int temp = nums[0];
        int index = 0;
        for (int i = 1; i < length; i++) {
            temp = Math.min(nums[i], nums[i] + temp);
            if (temp < min) {
                min = temp;
                index = i;
            }
        }
        System.out.println("index " + index);
        System.out.println(nums[index]);
        return index;
    }
}
