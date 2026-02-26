import java.util.*;
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
       int sum = 0;
       for(int num:nums)sum+=num;
       if(sum%k!=0)return false;
       int target = sum/k;
       Arrays.sort(nums);
       int n = nums.length;
       int[] buckets = new int[k];
       return backtrack(nums, n-1, buckets, target);
    }
    private boolean backtrack(int[] nums, int index, int[] buckets, int target){
        if(index<0)return true;
        for(int i = 0;i<buckets.length;i++){
            if(buckets[i]+nums[index]>target)continue;
            buckets[i]+=nums[index];
            if(backtrack(nums, index-1, buckets, target))return true;
            buckets[i]-= nums[index];
            if(buckets[i]==0)break;
        }
        return false;
    }
}