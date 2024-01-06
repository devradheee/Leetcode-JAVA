class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;
        for (int i = 1; i < m; i++) {
            int temp[] = new int[n];
            temp[0] = 1;
            for (int j = 1; j < n; j++) {
                // temp[j]+=(dp[j]+temp[j-1]);
                dp[j] += dp[j - 1];
            }
            // dp=temp;
        }
        return dp[n - 1];
    }
}