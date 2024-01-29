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
        ListNode dummy = new ListNode(0, head);
        ListNode startNode = dummy;
        while (startNode != null) {
            startNode = reverseKNodes(startNode, k);
        }
        return dummy.next;
    }
    public ListNode reverseKNodes(ListNode startNode, int k) {
        int i = 0;
        ListNode head = startNode.next;
        ListNode previous = head;
        ListNode current = head;
        ListNode next = null;    
        while (i < k) {
            if (previous == null) return null;
            previous = previous.next;
            i++;
        }
        for (int j = 0; j < k; j++) {      
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        startNode.next = previous;
        return head;
    }
}