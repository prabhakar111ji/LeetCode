class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int tT = 0;
        for(int i= 1;i<points.length;i++){
            int xd = Math.abs(points[i][0]-points[i-1][0]);
            int yd = Math.abs(points[i][1]-points[i-1][1]);
            tT += Math.max(xd, yd);
        }
        return tT;
    }
}