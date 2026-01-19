class Solution {
    public int maxSideLength(int[][] a, int t) {
        int m = a.length, n = a[0].length, ans = 0;
        int[][] p = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                p[i][j] = a[i - 1][j - 1] + p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1];
        for (int k = 1; k <= Math.min(m, n); k++)
            for (int i = k; i <= m; i++)
                for (int j = k; j <= n; j++)
                    if (p[i][j] - p[i - k][j] - p[i][j - k] + p[i - k][j - k] <= t)
                        ans = k;
        return ans;
    }
}
