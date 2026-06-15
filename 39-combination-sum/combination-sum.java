class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>ls = new ArrayList<>();
        f(candidates, target, 0, ans, ls, 0);
        return ans;
    }
    void f(int[] candidates, int target, int idx,List<List<Integer>> ans, List<Integer> ls, int sum){
        if(sum == target){
            ans.add(new ArrayList<Integer>(ls));
            return;
        }
        if(idx == candidates.length || sum>target)return;
        ls.add(candidates[idx]);
        f(candidates, target, idx, ans, ls, sum+candidates[idx]);
        ls.remove(ls.size()-1);
        f(candidates, target, idx +1, ans,ls, sum);
    }
}