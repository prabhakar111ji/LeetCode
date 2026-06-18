class Solution {
    public double angleClock(int hour, int minutes) {
        return Math.min(Math.abs(hour*30 - 5.5*minutes),360-Math.abs(hour*30 - 5.5*minutes));
    }
}