// package 0074_search-a-2d-matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j > -1) {
            int temp = matrix[i][j];
            if (target == temp) {
                return true;
            } else if (temp > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}