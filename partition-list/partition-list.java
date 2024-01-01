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
    public ListNode partition(ListNode head, int x) {
          ListNode dummy=new ListNode(0),tail=new ListNode(0);
        ListNode temp=head,t_head=dummy,t_tail=tail;
        while(temp!=null){
            if(temp.val<x){
                t_head.next=new ListNode(temp.val);
                t_head=t_head.next;
            }else{
                tail.next=new ListNode(temp.val);
                tail=tail.next;
            }
            temp=temp.next;
        }
        t_head.next=t_tail.next;
        return dummy.next;
    }
}