import java.util.*;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h = 1, v = 1, c = 1;
            for(int i = 1;i<hBars.length;i++){
                if(hBars[i] == hBars[i-1]+1)c++;
                else c =1;
                h = Math.max(h,c);
            }
        c = 1;
            for(int i = 1;i<vBars.length;i++){
                if(vBars[i] == vBars[i-1]+1)c++;
                else c = 1;
                v = Math.max(v,c);
            }
        int s = Math.min(h,v) + 1;
        return s*s;
    }
}