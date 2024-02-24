// package 0542_01-matrix;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] arr = new int[m][n];

        // Initialize arr with large values for cells containing 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE - 10000; // Avoid integer overflow
            }
        }

        // Iterate through each cell and find the minimum distance to a 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < n; y++) {
                            if (mat[x][y] == 0) {
                                arr[i][j] = Math.min(arr[i][j], Math.abs(x - i) + Math.abs(y - j));
                            }
                        }
                    }
                }
            }
        }

        return arr;
    }
}