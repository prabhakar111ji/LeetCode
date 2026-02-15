class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        Map<Integer,Integer> mpv = new LinkedHashMap<>();
        for(int x:mp.keySet()){
            int y = mp.get(x);
            mpv.put(y,mpv.getOrDefault(y,0)+1);
        }
        int y = 0;
        for(int x:nums){
            if(mpv.get(mp.get(x))==1)return x;
        }
        return -1;
    }
}