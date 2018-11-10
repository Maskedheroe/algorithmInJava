/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
     ListNode first = null;
        ListNode result = null;  //暂存结果节点 
        if (head==null){
            return null;
        }

        first = head;

        while (first!=null){
            
            ListNode second = first.next;  //second 暂存主链的节点！！！
            first.next = result;           //当前节点连接反转节点 
            result = first;                //反转节点的当前节点移位（向后移位）
            first = second;                //移交当前节点 

        }

        return result;
    }
}
