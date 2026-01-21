class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size(), ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (x == 2) ans[i] = -1;
            else {
                int t = x;
                while ((t & 1) == 1) t >>= 1;
                int mask = (x + 1) & ~(x);
                ans[i] = x ^ (mask >> 1);
            }
        }
        return ans;
    }
}