class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;// Most Imp because It will rotate only in size, prevent outside to go pointer
        rev(nums, 0, n-k-1);
        rev(nums, n-k, n-1);
        rev(nums, 0, n-1);
    }
    private void rev(int[] nums, int i, int j){
        int a = i, b = j;
        while(a<b){
            swap(nums, a, b);
            a++;
            b--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}