class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n-1;
        while(i<=j){
            int m = i+ (j-i)/2;
            if(nums[m] == target)return m;
            else if(nums[i]<=nums[m]){
                if(target>=nums[i] && target<=nums[m])j = m-1;
                else i = m+1;
            }
            else{
                if(target<=nums[j] && nums[m]<=target)i = m+1;
                else j = m-1;
            }
        }
        return -1;
    }
}