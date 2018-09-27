package com.example.hou.algorithminjava.practice;

/**
 *
 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * Created by hou on 2018/9/27.
 */

public class MergeLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {  //递归调用
        if(list1 == null){  //查完1 证明当前2最大 就返回2
            return list2;
        }
        if(list2 == null){  //查完2 证明当前1最大 就返回1
            return list1;
        }
        if(list1.val <= list2.val){   //1小于2 就在1上放置
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{                        //在2上放置
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

}
