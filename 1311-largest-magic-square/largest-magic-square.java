class Solution {
    public int largestMagicSquare(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] r = new int[m][n + 1], c = new int[m + 1][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                r[i][j + 1] = r[i][j] + g[i][j];
                c[i + 1][j] = c[i][j] + g[i][j];
            }
        for (int k = Math.min(m, n); k > 1; k--)
            for (int i = 0; i + k <= m; i++)
                for (int j = 0; j + k <= n; j++) {
                    int s = r[i][j + k] - r[i][j], d1 = 0, d2 = 0;
                    for (int x = 0; x < k; x++) {
                        if (r[i + x][j + k] - r[i + x][j] != s ||
                            c[i + k][j + x] - c[i][j + x] != s) break;
                        d1 += g[i + x][j + x];
                        d2 += g[i + x][j + k - 1 - x];
                        if (x == k - 1 && d1 == s && d2 == s) return k;
                    }
                }
        return 1;
    }
}
