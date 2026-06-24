class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx = Integer.MIN_VALUE;
        for(int x : piles)mx = Math.max(mx, x);
        int mn = 1;
        int ans = mx;
        while(mn<=mx){
            int md = mn + (mx-mn)/2;
            int t = 0;
            for(int x : piles){
                t+= Math.ceil((double)x/md);
                // int y = x%md;
                // int z = x/md;
                // if(y == 0)t+=z;
                // else t = t+z+1;
            }
            if(t<=h){
                ans = md;
                mx = md-1;
            }
            else{
                mn = md+1;
            }
        }
        return ans;
    }
}