package cn.fireflying;

/**
 * @author: Fire Flying
 * @create: 2021-12-21 21:34
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 * 
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 */
public class LeetCode22 {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        String str = "(";
        int left = n - 1;
        int right = n;
        generate(list, str, left, right);
        return list;
    }

    private static void generate(List<String> list, String str, int left, int right) {
        if (right == 0) {
            list.add(str);
            return;
        }
        int i = left;
        int j = right;
        if (left > 0 && left < right) {
            generate(list, str + "(", --i, right);
            generate(list, str + ")", left, --j);
        } else if (left == right) {
            generate(list, str + "(", --i, right);
        } else {
            generate(list, str + ")", left, --j);
        }
    }
    
}
