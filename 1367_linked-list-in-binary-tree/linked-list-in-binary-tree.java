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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        if(dfs(head, root)) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    private boolean dfs(ListNode h, TreeNode node) {
        if(h == null) return true;
        if(node == null) return false;
        if(node.val == h.val) 
            return dfs(h.next, node.left) || dfs(h.next, node.right);
        return false;
    }
}