class Solution {
    public boolean hasAlternatingBits(int n) {
        // remember following both line
        int x = n ^ (n>>1);
        return (x & x+1) == 0;
    }
}