package com.example.hou.algorithminjava.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MiddleOTLS {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            List<ListNode> lists = new ArrayList<>();
            while (head != null) {
                lists.add(head);
                head = head.next;
            }

            return lists.get(lists.size() / 2);    //仔细思考 奇数除以二 是正确的、中间的数； 偶数除以二 是中间两个数的第二个  正好是商的下标
            /**
             * 方法二：快慢指针法
             * 思路和算法
             *
             * 当用慢指针 slow 遍历列表时，让另一个指针 fast 的速度是它的两倍。当 fast 到达列表的末尾时，slow 必然位于中间。
             class Solution {
             public ListNode middleNode(ListNode head) {
                 ListNode slow = head, fast = head;
                 while (fast != null && fast.next != null) {
                     slow = slow.next;
                     fast = fast.next.next;
                 }
                 return slow;
                 }
             }
             时间复杂度：O(N)O(N)，其中 NN 是给定列表的结点数目

             空间复杂度：O(1)O(1)，slow 和 fast 用去的空间。


             * */
        }
    }
}
