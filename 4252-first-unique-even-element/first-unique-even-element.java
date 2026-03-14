class Solution {
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i]%2==0)mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(int x : mp.keySet()){
            if(mp.get(x) == 1)return x;
        }
        return -1;
    }
}