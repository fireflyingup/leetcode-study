package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2022-01-10 00:00
 **/

public class LeetCode1629 {

    public static void main(String[] args) {
//        System.out.println(slowestKey(new int[] {12,23,36,46,62}, "spuda"));
        System.out.println(slowestKey(new int[] {1, 2}, "ba"));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char s = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            if (max < temp) {
                max = temp;
                s = keysPressed.charAt(i);
            } else if (max == temp) {
                if (s < keysPressed.charAt(i)) {
                    s = keysPressed.charAt(i);
                }
            }
        }
        return s;
    }
}
