class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, cnt = 0;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) cnt++;
            if (++freq[B[i]] == 2) cnt++;

            ans[i] = cnt;
        }

        return ans;
    }
}