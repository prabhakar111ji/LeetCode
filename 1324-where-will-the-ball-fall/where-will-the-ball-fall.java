class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = i;
            for (int j = 0; j < m; j++) {
                int next = curr + grid[j][curr];
                if (next < 0 || next >= n || grid[j][curr] != grid[j][next]) {
                    curr = -1;
                    break;
                }
                curr = next;
            }
            res[i] = curr;
        }
        return res;
    }
}