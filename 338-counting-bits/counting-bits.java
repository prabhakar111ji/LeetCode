class Solution {
    private int noOfone(int n){
        int  x= 0;
        int cnt = 0;
        int prevNum = 0;
        while(n>0){
            int rem = n%2;
            if(rem == 1)cnt++;
            prevNum = rem*(int)Math.pow(10,x++) + prevNum;
            n/=2;
        }
        return cnt;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0;i<=n;i++){
            ans[i] = noOfone(i);
        }
        return ans;
    }
}