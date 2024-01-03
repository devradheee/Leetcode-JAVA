class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // for(int i=1; i<n; i++) grid[0][i]+=grid[0][i-1];
        // for(int i=1; i<m; i++) grid[i][0]+=grid[i-1][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    grid[i][j] = grid[i][j];
                else if (i == 0 && j > 0)
                    grid[i][j] += grid[i][j - 1];
                else if (j == 0 && i > 0)
                    grid[i][j] += grid[i - 1][j];
                else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}