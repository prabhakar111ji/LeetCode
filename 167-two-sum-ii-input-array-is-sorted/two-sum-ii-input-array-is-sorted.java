class Solution {
    public int[] twoSum(int[] num, int t) {
        int n = num.length, l = 0, r = n-1;
        while(l<r){
            // int m  = l + (r-l)/2;
            if(num[l] + num[r] == t)return new int[]{l+1, r+1};
            else if(num[l] + num[r]<t){
                l++;
            }
            else{
                r--;
            }
        }
        return new int[]{-1,-1};
        // while(l<r){
        //     if()
        // }
    }
}