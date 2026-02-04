import java.util.*;
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        int k = groupSize;
        if(n%k!=0)return false;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int x : hand){
            mp.put(x, mp.getOrDefault(x,0)+1);
        }
        while(!mp.isEmpty()){
            int start = mp.firstKey();
            for(int i = 0;i<k;i++){
                int curr = start + i;
                if(!mp.containsKey(curr))return false;
                mp.put(curr,mp.get(curr)-1);
                if(mp.get(curr) == 0)mp.remove(curr);
            }
        }
        return true;
    }
} 