class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, n, k, ans, new ArrayList<>());
        return ans;
    }

    void helper(int idx, int n, int k, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if (ds.size() == k) {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for (int i = idx; i <= n; i++) {
            ds.add(i);
            helper(i + 1, n, k, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}