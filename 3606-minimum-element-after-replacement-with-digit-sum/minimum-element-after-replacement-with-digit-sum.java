class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            nums[i] = sum(nums[i]);
            min = Math.min(min, nums[i]);
        }
        return min;
    
    }
    private int sum(int n){
        int t = n;
        int s = 0;
        while(t>0){
            int r = t%10;
            s+=r;
            t/=10;
        }
        return s;
    }
}