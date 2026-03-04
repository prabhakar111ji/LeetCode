class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, c = 0;
        int[] rowcount = new int[m];
        int[] colcount = new int[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==1){rowcount[i]++;colcount[j]++;}
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1 && rowcount[i] == 1 && colcount[j] ==1)c++;
            }
        }
        return c;
    }
}