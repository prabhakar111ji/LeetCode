class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;
        rev(nums, 0, n-k-1);
        rev(nums, n-k,n-1);
        rev(nums, 0, n-1);
    }
    private void rev(int[] nums, int a, int b){
        int i = a, j = b;
        while(i<j){
            swap(nums, i,j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}