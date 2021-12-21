package cn.fireflying.leetcode_25;

/**
 * @author: Fire Flying
 * @create: 2021-12-16 19:02
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode prev;
        ListNode next;
        int count = k;
        while (head.next != null) {

        }
        return null;
    }

    public static void main(String[] args) {

    }
}