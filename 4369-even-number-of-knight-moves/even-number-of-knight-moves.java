class Solution {
    public boolean canReach(int[] start, int[] target) {
        // first sol
        // return (start[0] + start[1])%2 == (target[0] + target[1])%2;
        
        // second sol
        return (Math.abs(start[1] - start[0]) & 1) == (Math.abs(target[1] - target[0]) & 1);
    }
}