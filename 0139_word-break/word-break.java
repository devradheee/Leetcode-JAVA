// package 0139_word-break;

class Solution {
    private static int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String g : wordDict)
            set.add(g);
        dp = new int[300];
        Arrays.fill(dp, -1);

        return solve(set, s.toCharArray(), 0) == 1 ? true : false;
    }

    private static int solve(Set<String> set, char[] s, int ptr) {
        if (ptr == s.length)
            return 1;
        if (dp[ptr] != -1)
            return dp[ptr];
        StringBuilder sb = new StringBuilder("");
        for (int i = ptr; i < s.length; i++) {
            sb.append(String.valueOf(s[i]));
            if (set.contains(sb.toString())) {
                if (solve(set, s, i + 1) == 1)
                    return dp[i] = 1;
            }
        }
        return dp[ptr] = 0;
    }
}
