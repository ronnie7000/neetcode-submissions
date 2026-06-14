/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode res = null;
        for(ListNode head : lists) {
            res = mergeLists(res, head);
        }

        return res;
    }

    private ListNode mergeLists(ListNode headA, ListNode headB) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(headA != null && headB != null) {
            if(headA.val < headB.val) {
                temp.next = headA;
                headA = headA.next;
            } else {
                temp.next = headB;
                headB = headB.next;
            }
            temp = temp.next;
        }

        if(headA != null) {
            temp.next = headA;
        } else if (headB != null) {
            temp.next = headB;
        }

        return head.next;
    }
}
