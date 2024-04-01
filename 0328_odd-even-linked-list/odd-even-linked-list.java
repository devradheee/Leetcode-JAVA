class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        if (head.next.next == null)
            return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddCurrent = oddHead, evenCurrent = evenHead;
        while (oddCurrent != null) {
            ListNode tempEven = oddCurrent.next;
            if (oddCurrent.next != null) {
                oddCurrent.next = oddCurrent.next.next;
            }

            evenCurrent.next = tempEven;
            evenCurrent = evenCurrent.next;
            if (oddCurrent.next == null)
                break;
            oddCurrent = oddCurrent.next;
        }
        oddCurrent.next = evenHead;
        return oddHead;
    }
}