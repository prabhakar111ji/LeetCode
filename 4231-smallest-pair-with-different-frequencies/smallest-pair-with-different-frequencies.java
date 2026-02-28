class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);
        int[] f = new int[101];
        for(int num: nums)f[num]++;
        for(int i = 1;i<101;i++){
            for(int j = i+1;j<101;j++){
                if( (f[i]!=0 && f[j]!=0) && f[i]!=f[j])return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}