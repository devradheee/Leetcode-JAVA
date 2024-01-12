class Solution {
    int dp[][][] = new int[11][10][2];

    public int countDigitOne(int n) {
        for (int arr[][] : dp) for (int arr2[] : arr) Arrays.fill(arr2, -1);
        return helper(n + "", 0, 1, 0);
    }

    int helper(String num, int idx, int limit, int sum) {
        if (num.length() == idx) {
            return sum;
        }

        if (dp[idx][sum][limit] != -1) return dp[idx][sum][limit];
        int end = (limit == 1) ? (num.charAt(idx) - '0') : 9;
        int ans = 0;
        for (int dig = 0; dig <= end; dig++) {
            int new_limit = (limit == 1 && dig == end) ? 1 : 0;
            int to_add = (dig == 1 ? 1 : 0);
            ans = ans + helper(num, idx + 1, new_limit, sum + to_add);
        }

        return dp[idx][sum][limit] = ans;
    }
}