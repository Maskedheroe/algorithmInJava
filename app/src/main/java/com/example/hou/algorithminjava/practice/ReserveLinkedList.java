package com.example.hou.algorithminjava.practice;

import java.util.ArrayList;

/**
 * Created by hou on 2018/9/26.
 */

public class ReserveLinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        /*
        *
        * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
        * */

        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode pre=null;
        ListNode next=null;
        while(listNode!=null){
            /*
            * 每次循环从链表拆下一个node  组成一个新的倒序的链表
            *
            * 需要仔细画图揣摩
            * */
            next=listNode.next;
            listNode.next=pre;
            pre=listNode;
            listNode=next;
        }
        while(pre!=null){
            list.add(pre.val);
            pre=pre.next;
        }
        return list;
    }

    class ListNode{
         ListNode next = null;
         int val = 0;
    }
}
