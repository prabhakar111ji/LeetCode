class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int maxA = Integer.MIN_VALUE, minA = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE, minB = Integer.MAX_VALUE;
        
        for (int num : nums1) {
            maxA = Math.max(maxA, num);
            minA = Math.min(minA, num);
        }
        for (int num : nums2) {
            maxB = Math.max(maxB, num);
            minB = Math.min(minB, num);
        }
        
        if (maxA < 0 && minB > 0) return maxA * minB;
        if (minA > 0 && maxB < 0) return minA * maxB;
        
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            int[] next = new int[n + 1];
            next[0] = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int prod = nums1[i] * nums2[j];
                
                int withPrev = dp[j];
                if (withPrev > Integer.MIN_VALUE) {
                    withPrev += prod;
                }
                
                int bestWith = Math.max(prod, withPrev);
                int bestWithout = Math.max(dp[j + 1], next[j]);
                next[j + 1] = Math.max(bestWith, bestWithout);
            }
            dp = next;
        }
        
        return dp[n];
    }
}