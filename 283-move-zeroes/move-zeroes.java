class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                int j = i+1;
                while(j<n){
                    if(nums[j]!=0){
                        swap(nums, i, j);
                        break;
                    }
                    else j++;
                }
            }
        }
    }
    private void swap(int[] nums, int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}