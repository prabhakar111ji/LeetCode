class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n%k!=0)return false;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int x : nums){
            mp.put(x, mp.getOrDefault(x,0)+1);
        }
        while(!mp.isEmpty()){
            int start = mp.firstKey();
            for(int i = 0;i<k;i++){
                int curr = start + i;
                if(!mp.containsKey(curr))return false;
                mp.put(curr, mp.get(curr)-1);
                if(mp.get(curr) == 0)mp.remove(curr);
            }
        }
        return true;
    }
}