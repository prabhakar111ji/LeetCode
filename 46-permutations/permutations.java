class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length)res.add(new ArrayList(curr));
        for(int i = 0;i<nums.length;i++){
            if(curr.contains(nums[i]))continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, used, curr, res);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}