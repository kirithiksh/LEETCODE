class Solution {
    void addToAns(int[][] board, List<List<String>> ans){
        List<String> temp = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            StringBuilder s = new StringBuilder();
            for(int j=0; j<board.length; j++){
                if(board[i][j]==1){
                    s.append('Q');
                }
                else{
                    s.append('.');
                }
            }
            temp.add(s.toString());
        }
        ans.add(temp);
    }

    boolean isSafe(int row, int col, int n, int[][] board){
        //row
        for(int c=0; c<=col-1; c++){
            if(board[row][c]==1) return false;
        }
        //upper left diagonal
        for(int r=row, c=col; r>=0 && c>=0; r--, c--){
            if(board[r][c]==1) return false;
        }
        //lower left diagonal
        for(int r=row, c=col; r<=n-1 && c>=0; r++, c--){
            if(board[r][c]==1) return false;
        }
        //valid position to place the queen
        return true;
    }

    void f(int col, int n, int[][] board, List<List<String>> ans){
        if(col==n){ //add board to the ans
            addToAns(board, ans);
            return;
        }
        for(int row = 0; row<n; row++){
            // current cell-> (row,col)
            if(isSafe(row,col,n,board)){
                board[row][col]=1;
                f(col+1, n, board, ans);
                //backtrack
                board[row][col]=0;
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        f(0, n, board, ans);
        return ans;
    }
}