class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0, low = 2e9, high = 0;
        for (int[] s : squares) {
            totalArea += (double) s[2] * s[2];
            low = Math.min(low, (double) s[1]);
            high = Math.max(high, (double) s[1] + s[2]);
        }
        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2, areaBelow = 0;
            for (int[] s : squares) {
                if (s[1] + s[2] <= mid) areaBelow += (double) s[2] * s[2];
                else if (s[1] < mid) areaBelow += (mid - s[1]) * s[2];
            }
            if (areaBelow < totalArea / 2.0) low = mid;
            else high = mid;
        }
        return low;
    }
}
