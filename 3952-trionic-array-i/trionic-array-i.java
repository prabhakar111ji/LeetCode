class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length, i = 1;
        // increment
        while(i<n && nums[i]>nums[i-1])i++;
        if(i == 1 || i == n)return false;
        // ḍecrement
        int d = i;
        while(i<n && nums[i]<nums[i-1])i++;
        if(i == d || i==n)return false;
        // increment
        while(i<n && nums[i]>nums[i-1])i++;
        return i==n;
    }
}