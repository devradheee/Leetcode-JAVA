class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, k, n, new LinkedList(), ans);
        return ans;
    }

    private void helper(int start, int k, int n, LinkedList ll, List<List<Integer>> ans) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(ll));
        }
        for (int i = start; i <= 9; i++) {
            ll.add(i);
            helper(i + 1, k - 1, n - i, ll, ans);
            ll.removeLast();
        }
    }
}