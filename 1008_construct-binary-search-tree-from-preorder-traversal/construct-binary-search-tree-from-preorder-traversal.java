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
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {
        // base condition
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // getting root from first element of preorder(root, left, right).
        TreeNode root = new TreeNode(preorder[preStart]);
        // finding that element in inorder.
        int inMap = map.get(root.val);
        // left part in inorder.
        int numsLeft = inMap - inStart;
        // main logic
        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inMap - 1, map);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inMap + 1, inEnd, map);

        return root;

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        // getting inorder from preorder by sorting the preorder.
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        // storing values of inorder in a map.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;

    }
}