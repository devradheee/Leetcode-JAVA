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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head, next = head.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
        }
        
            cur.next = prev;
            // prev = cur;
            // cur = next;
            // next = cur.next;
        return cur;
    }
}