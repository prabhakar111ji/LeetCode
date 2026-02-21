class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, right = 0, n = fruits.length;
        int maxFruits = 0, currentFruits = 0;

        while (right < n) {
            currentFruits += fruits[right][1];
            
            // Calculate minimum steps needed for current window [left, right]
            while (left <= right && getMinSteps(fruits[left][0], fruits[right][0], startPos) > k) {
                currentFruits -= fruits[left][1];
                left++;
            }
            maxFruits = Math.max(maxFruits, currentFruits);
            right++;
        }
        return maxFruits;
    }

    private int getMinSteps(int lPos, int rPos, int startPos) {
        // Distance to cover range + extra distance to turn around
        return (rPos - lPos) + Math.min(Math.abs(startPos - lPos), Math.abs(startPos - rPos));
    }
}
