/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, 0);
    }

    int helper(TreeNode root, int level) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.left == null && root.right == null)
            return level + 1;

        int left = Integer.MAX_VALUE;
        // if(root.left!=null)
        left = helper(root.left, level + 1);
        int right = Integer.MAX_VALUE;
        // if(root.right!=null)
        right = helper(root.right, level + 1);

        return Math.min(left, right);
    }
}