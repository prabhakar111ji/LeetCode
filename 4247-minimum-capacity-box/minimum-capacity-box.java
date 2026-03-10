class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length, ans = -1, min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(capacity[i]>=itemSize){
                if(min>capacity[i]){
                    ans = i;
                    min = capacity[i];
                }
            }
        }
        return ans;
    }
}