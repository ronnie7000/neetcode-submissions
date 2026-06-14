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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return head;
        }

        ListNode temp = head;
        
        for(int i = 0; i < k; i++) {
            if(temp == null) {
                return head;
            }
            temp = temp.next;
        }

        ListNode curr = head, prev = null;
        int count = 0;

        while(curr != null && count < k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
