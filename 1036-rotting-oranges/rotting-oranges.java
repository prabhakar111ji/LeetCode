class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, fsh = 0;
        Queue<int[]> q= new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 2)q.offer(new int[]{i,j});
                else if(grid[i][j] == 1)fsh++;
            }
        }
        if(fsh == 0)return 0;
        int mnts = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            boolean infected = false;
            for(int k = 0;k<size;k++){
                int[] cur = q.poll();
                for(int[] d : dir){
                    int r = cur[0] + d[0];
                    int c = cur[1] + d[1];
                    if(r>=0 && c>=0 &&r<m&& c<n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fsh--;
                        q.offer(new int[]{r,c});
                        infected = true;
                    }
                }
            }
            if(infected)mnts++;
        }
        return fsh == 0 ? mnts : -1;
    }
}