class Solution {
    public long largestSquareArea(int[][] b, int[][] t) {
        int n = b.length;
        long ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int x = Math.min(t[i][0], t[j][0]) - Math.max(b[i][0], b[j][0]);
                int y = Math.min(t[i][1], t[j][1]) - Math.max(b[i][1], b[j][1]);
                int s = Math.min(x, y);
                if (s > 0) ans = Math.max(ans, (long) s * s);
            }
        return ans;
    }
}
