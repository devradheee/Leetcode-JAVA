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
public class Solution {

    public int sizeOfList(ListNode head) {
        ListNode pTmp = head;
        int count = 0;
        while (pTmp != null) {
            pTmp = pTmp.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = sizeOfList(head);

        if (size == 0 || k % size == 0) {
            return head;
        }

        int steps = size - k % size;
        ListNode pTmp = head;
        ListNode pPre = null;

        for (int i = 0; i < steps; i++) {
            pPre = pTmp;
            pTmp = pTmp.next;
        }
        pPre.next = null;

        ListNode newHead = pTmp;
        while (pTmp.next != null) {
            pTmp = pTmp.next;
        }
        pTmp.next = head;

        return newHead;
    }
}