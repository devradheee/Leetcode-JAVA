/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      
        if (head == null || head.next == null)
        return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;

        ListNode matchNode = null;

        while(slowPtr != null && fastPtr != null){

            if (slowPtr == fastPtr)
            {
                matchNode = slowPtr;
                break;
            }
            slowPtr = slowPtr.next;

            fastPtr = fastPtr.next;
            if (fastPtr != null)
            fastPtr = fastPtr.next;
        }

        if (matchNode == null)
            return null;

        int outOfLoopLength = 0;
        int loopLength = 1;

        ListNode loopStepper = matchNode.next;
        while(loopStepper != null && loopStepper != matchNode) 
        {
            loopStepper = loopStepper.next;
            loopLength++;
        }

        ListNode outOfLoop = head;
        loopStepper = head;

        int ct = 0;
        while(ct < loopLength) {
            loopStepper = loopStepper.next;
            ct++;
        }

        while (outOfLoop != loopStepper)
        {
            outOfLoop = outOfLoop.next;
            loopStepper = loopStepper.next;
        }

        return loopStepper;  
    }
}