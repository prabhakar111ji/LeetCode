class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        int[] f = new int[101];
        for(int i = 0;i<nums.length;i++){
            l = Math.min(l, nums[i]);
            h = Math.max(h, nums[i]);
            f[nums[i]]++;
        }
        for(int i =2;i<=100;i++){
            if(f[i]==0 && i>l && i<h)ls.add(i);
        }
        return ls;
        // Arrays.sort(nums);
        // int s = nums[0];
        // int l = nums[nums.length-1];
        // for(int i = s+1; i<nums.length;i++){
        //     if(nums[i]-1!=nums[i-1])ls.add(nums[i]-1);
        // }
        // return ls;
        // int i = 0;
        // while(i<nums.length){
        //     if(nums[i]-1 == nums[i-1]){
        //         ls.add(i);
        //         // System.out.println(i+s);
        //         // i++;
        //     }
        //     else i++;
        // }
        // return ls;
    }
}