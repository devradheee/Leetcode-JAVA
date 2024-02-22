// package 0173_binary-search-tree-iterator;

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
class BSTIterator {
    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root) {
        help(root);
    }

    public int next() {
        TreeNode h = s.pop();
        help(h.right);
        return h.val;
    }

    public boolean hasNext() {
        if (s.isEmpty())
            return false;
        return true;
    }

    void help(TreeNode r) {
        if (r == null)
            return;
        s.push(r);
        help(r.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */