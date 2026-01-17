import java.util.*;
class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int cx = center[0], cy = center[1], max = Integer.MIN_VALUE;
        int[] ans = {-1,-1};
        for(int[] t : towers){
            int x = t[0], y = t[1], q = t[2];
            int d = Math.abs(cx-x) + Math.abs(cy-y);
                if(d<=radius){
                    if(q>max || (q == max && (x<ans[0] || (x==ans[0] && y <ans[1])))){
                        
                        max = q;
                        ans[0] = x;
                        ans[1] = y;
                    }
                }
        }
        return ans;
    }
}