class Solution {
    int m, n, o;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        o = word.length();
        boolean flag = false;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == word.charAt(0))
                    flag = flag || bktk(board, word, i, j, 1);
            }
        }
        return flag;
    }
    boolean isValid(int i, int j){
        if(i<0 || j<0 || i>=m || j>=n)return false;
        return true;
    }
    boolean bktk(char[][] board, String word, int i, int j, int k){
        
        if(k>=o)return true;

        char val = board[i][j];
        board[i][j] = '*';
        boolean flag = false;
        if(isValid(i+1, j) && board[i+1][j] == word.charAt(k)){
            flag = flag || bktk(board, word, i+1, j, k+1);
        }
        if(isValid(i, j+1) && board[i][j+1] == word.charAt(k)){
            flag = flag || bktk(board, word, i, j+1, k+1);
        }
        if(isValid(i-1, j) && board[i-1][j] == word.charAt(k)){
            flag = flag || bktk(board, word, i-1, j, k+1);
        }
        if(isValid(i, j-1) && board[i][j-1] == word.charAt(k)){
            flag = flag || bktk(board, word, i, j-1, k+1);
        }

        board[i][j] = val;

        return flag;
    }
}