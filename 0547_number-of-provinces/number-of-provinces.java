// package 0547_number-of-provinces;

class Solution {
    public int findCircleNum(int[][] mat) {
        int ans = 0, n = mat.length;
        boolean visit[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                ans++;
                dfs(i, visit, mat);
            }
        }
        return ans;
    }

    public void dfs(int node, boolean[] visit, int[][] mat) {
        visit[node] = true;
        for (int i = 0; i < mat.length; i++) {
            if (!visit[i] && mat[node][i] == 1)
                dfs(i, visit, mat);
        }
    }
}