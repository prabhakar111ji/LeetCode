class Solution {
    public int countPyramids(int[][] grid) {
        return solve(grid) + solve(reverse(grid));
    }

    private int solve(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 1;
                    if (i < m - 1 && j > 0 && j < n - 1) {
                        dp[i][j] += Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    }
                    count += dp[i][j] - 1;
                }
            }
        }
        return count;
    }

    private int[][] reverse(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rev = new int[m][n];
        for (int i = 0; i < m; i++) rev[i] = grid[m - 1 - i];
        return rev;
    }
}
