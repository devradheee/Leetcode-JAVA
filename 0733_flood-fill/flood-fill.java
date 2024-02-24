class Solution {
    int x, clr, n, m;

    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        x = grid[sr][sc];
        clr = color;
        n = grid.length;
        m = grid[0].length;
        bfs(sr, sc, grid);
        return grid;
    }

    public void bfs(int i, int j, int[][] grid) {
        grid[i][j] = clr;
        if (i > 0 && grid[i - 1][j] == x && grid[i - 1][j] != clr)
            bfs(i - 1, j, grid);
        if (i < n - 1 && grid[i + 1][j] == x && grid[i + 1][j] != clr)
            bfs(i + 1, j, grid);
        if (j > 0 && grid[i][j - 1] == x && grid[i][j - 1] != clr)
            bfs(i, j - 1, grid);
        if (j < m - 1 && grid[i][j + 1] == x && grid[i][j + 1] != clr)
            bfs(i, j + 1, grid);
    }
}