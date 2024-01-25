

class Solution {
    private void f(int index, int[] nums, List<Integer> t, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(t));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            t.add(nums[i]);
            f(i + 1, nums, t, ans);
            t.remove(t.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();

        Arrays.sort(nums);
        f(0, nums, t, ans);
        return ans;
    }
}
