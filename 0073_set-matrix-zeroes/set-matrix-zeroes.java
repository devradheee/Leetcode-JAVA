class Solution {
    public void setZeroes(int[][] matrix) {
       int row=matrix.length;
       int col=matrix[0].length;

        List<Integer> lr = new ArrayList<>();
        List<Integer> lc = new ArrayList<>();

       for(int i=0;i<row;i++)
       {
           for(int j=0;j<col;j++)
           {
               if(matrix[i][j]==0)
               {
                   lr.add(i);
                   lc.add(j);
               }
           }
       }
       row_zero(matrix , lr , col); 
       column_zero(matrix , lc , row);


    }

    public void row_zero(int[][] mat , List<Integer> lr, int col)
    {
        for(int r : lr)
        {
            for(int j=0;j<col;j++)
            {
                mat[r][j]=0;
            }
        }
    }
     public void column_zero(int[][] mat , List<Integer> lc, int row)
    {
        for(int c : lc)
        {
            for(int j=0;j<row;j++)
            {
                mat[j][c]=0;
            }
        }
    }
}
