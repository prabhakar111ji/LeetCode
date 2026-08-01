class Solution {
    public int countValidPrefixes(String s) {
        int z = 0, o = 0, ans = 0;
        for(char c: s.toCharArray()){
            if(c=='1')o++;
            else if(c=='0')z++;
            if(Math.abs(o-z)<=1)ans++;
        }
        return ans;
    }
}