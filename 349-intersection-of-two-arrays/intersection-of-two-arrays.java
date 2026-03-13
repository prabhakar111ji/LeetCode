class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Set<Integer> mp = new HashSet<>();
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i] == nums2[j])mp.add(nums1[i]);
            }
        }
        int s = mp.size(),i = 0;
        int  ans[] = new int[s];
        for(int x:mp){
            ans[i++] = x;
        }
        return ans;
    }
}