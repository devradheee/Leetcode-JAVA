// package 0236_lowest-common-ancestor-of-a-binary-tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        nodeToRootPath_(root, p.val, list1);
        nodeToRootPath_(root, q.val, list2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;
        TreeNode prev = null;
        while (i >= 0 && j >= 0) {

            if (list1.get(i).val != list2.get(j).val)
                break;

            prev = list1.get(i);
            i--;
            j--;
        }
        return prev;
    }

    public boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> path) {
        if (root == null)
            return false;
        if (root.val == data) {
            path.add(root);
            return true;
        }

        boolean lp = nodeToRootPath_(root.left, data, path);
        if (lp) {
            path.add(root);
            return true;
        }
        boolean rp = nodeToRootPath_(root.right, data, path);
        if (rp) {
            path.add(root);
            return true;
        }

        return false;
    }
}