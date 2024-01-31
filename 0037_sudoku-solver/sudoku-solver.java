class Solution {
    public boolean solve(char board[][], int row, int col) {
        if (row == board.length)
            return true;

        int newrow = 0;
        int newcol = 0;
        if (col == board.length - 1) {
            newrow = row + 1;
            newcol = 0;
        } else {
            newrow = row;
            newcol = col + 1;
        }
        if (board[row][col] != '.') {
            if (solve(board, newrow, newcol))
                return true;
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isSafe(board, row, col, ch)) {
                    board[row][col] = ch;
                    if (solve(board, newrow, newcol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch)
                return false;
            if (board[i][col] == ch)
                return false;
            int startRow = 3 * (row / 3);
            int startCol = 3 * (col / 3);
            for (int k = startRow; k < startRow + 3; k++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[k][j] == ch)
                        return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);

    }
}
