class Solution {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < third)
                return true;

            while (!st.isEmpty() && nums[i] > st.peek())
                third = st.pop();

            st.push(nums[i]);
        }

        return false;
    }
}