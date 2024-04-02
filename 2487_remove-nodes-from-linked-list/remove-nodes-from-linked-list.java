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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        ListNode temp = head;
        while(temp != null){
            s1.push(temp.val);
            temp = temp.next;
        }
        s2.push(s1.pop());
        while(!s1.empty()){
            if(s2.peek() > s1.peek()) s1.pop();
            else s2.push(s1.pop());
        }
        ListNode result = new ListNode(s2.pop());
        ListNode newHead = result;
        while(!s2.empty()){
            newHead.next = new ListNode(s2.pop());
            newHead = newHead.next;
        }
        return result;
    }
}