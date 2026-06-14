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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }

        ListNode beforeMid = getMid(head);
        ListNode mid = beforeMid.next;
        beforeMid.next = null;

        ListNode headA = head.next;
        ListNode temp = head;
        ListNode headB = reverse(mid);
        boolean flag = false;

        while(headA != null && headB != null) {
            if(flag) {
                temp.next = headA;
                headA = headA.next;
            } else {
                temp.next = headB;
                headB = headB.next;
            }
            temp = temp.next;
            flag = !flag;
        }

        if(headA != null) {
            temp.next = headA;
        } else if (headB != null) {
            temp.next = headB;
        }
    }

    private ListNode getMid(ListNode head) {
        ListNode prev = null, slow = head, fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = curr.next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
