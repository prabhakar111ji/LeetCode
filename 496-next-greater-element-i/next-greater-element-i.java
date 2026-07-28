class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int x = -1;
            for(int j = 0;j<m;j++){
                if(nums1[i]==nums2[j]){
                    x = j;
                }
                else if(x>-1 && nums2[j]>nums1[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
            if(ans[i]==0)ans[i]=-1;
        }
        return ans;
    }
}