class Solution {
    public int rob(int[] nums) {
        var dp = new int[nums.length + 3]; // Creating dp array for storing max sums

        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 2], dp[i + 3]) + nums[i]; // checking which house is better to rob -> after one or after two
        }

        return Math.max(dp[0], dp[1]); //max should be stored in first or second section in array
    }
}