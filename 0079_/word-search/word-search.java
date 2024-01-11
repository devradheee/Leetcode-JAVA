class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0) && helper(board,i,j,word,0)) return true;
            }
        }
           return false;
    }
    
    boolean helper(char[][] board,int i,int j,String word,int idx){
        if(word.length()==idx) return true;
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]!='.' && board[i][j]==word.charAt(idx)){
            int no=1;
            char ch=board[i][j];
            board[i][j]^=256;
            boolean get= helper(board,i+1,j,word,idx+no) || 
                helper(board,i,j+1,word,idx+no) || 
                helper(board,i-1,j,word,idx+no) || 
                helper(board,i,j-1,word,idx+no);
            board[i][j]^=256;
            return get;
        }
        return false;
    }
}