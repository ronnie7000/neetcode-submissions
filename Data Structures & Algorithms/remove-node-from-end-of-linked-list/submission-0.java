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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        int length = getLength(head);

        if(n > length) {
            return head;
        } 
        // else if (n == 1) {
        //     return head.next;
        // }
        
        ListNode prev = null, curr = head;

        for(int i = 1; i <= (length - n); i++) {
            prev = curr;
            curr = curr.next;
        }

        if(prev == null) {
            return head.next;
        } else {
            prev.next = curr.next;
            curr.next = null;
        }
        
        return head;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;

        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
