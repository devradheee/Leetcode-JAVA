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
    private int maxDepth;
    private int bottomLeft;

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        bottomLeft = 0;
        dfs(root, 0);
        return bottomLeft;
    }

    private void dfs(TreeNode curr, int depth) {
        if (curr == null) {
            return;
        }
        if (depth > maxDepth) { 
            maxDepth = depth;
            bottomLeft = curr.val;
        }
        dfs(curr.left, depth + 1);
        dfs(curr.right, depth + 1);
    }
}