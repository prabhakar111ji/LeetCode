class DetectSquares {
    int[][] cnt = new int[1001][1001];
    List<int[]> pts = new ArrayList<>();
    public void add(int[] p) { cnt[p[0]][p[1]]++; pts.add(p); }
    public int count(int[] p) {
        int x1 = p[0], y1 = p[1], ans = 0;
        for (int[] pt : pts) {
            int x2 = pt[0], y2 = pt[1];
            int d = Math.abs(x1 - x2);
            if (d > 0 && d == Math.abs(y1 - y2)) 
                ans += cnt[x1][y2] * cnt[x2][y1];
        }
        return ans;
    }
}
