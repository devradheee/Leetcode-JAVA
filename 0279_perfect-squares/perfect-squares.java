class Solution {
    int dp[];

    public int numSquares(int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, (int) 1e5);
        dp[0] = 0;

        for (int n = 1; n <= target; n++) {
            for (int no = 1; no * no <= n; no++) {
                int take = 1 + dp[n - (no * no)];
                int nottake = dp[n];
                dp[n] = Math.min(take, nottake);
            }
        }

        return dp[target];
    }

    int helper(int no, int n) {
        if (n == 0) {
            return 0;
        }

        if ((no * no) > n)
            return (int) 1e5;

        if (dp[n] != -1)
            return dp[n];

        int take = 1 + helper(no, n - (no * no));
        int nottake = helper(no + 1, n);

        return dp[n] = Math.min(take, nottake);
    }
}