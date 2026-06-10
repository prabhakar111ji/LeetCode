class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        long pdct = 1;
        int noz = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0)noz++;
            pdct*=nums[i];
        }
        if(noz>1){
            for(int i = 0;i<n;i++)nums[i] = 0;
        }
        else if(pdct == 0 && noz==1){
            pdct = 1;
            for(int i = 0;i<n;i++){
                if(nums[i]!=0)pdct*=nums[i];
            }
            for(int i = 0;i<n;i++){
                if(nums[i]!=0)nums[i] =0;
                else nums[i] = (int)pdct;
            }
        }
        else{
            for(int i = 0;i<n;i++){
           nums[i]= (int)pdct/nums[i];
        }
        }
        return nums;
    }
}