// package 0098_validate-binary-search-tree;

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
    ArrayList<Integer> result = new ArrayList<>();

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 0; i < result.size() - 1; ++i) {
            if (result.get(i) >= result.get(i + 1))
                return false;
        }
        return true;
    }
}