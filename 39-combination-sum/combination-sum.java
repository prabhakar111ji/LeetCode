class Solution {
    public List<List<Integer>> combinationSum(int[] c, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        backtrack(0, c, t, ans, ls, 0);
        return ans;

    }
    public void backtrack(int i, int[] c, int t, List<List<Integer>> ans, List<Integer> ls, int sum){
        if(sum == t){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(i == c.length || sum>t)return;
        
        ls.add(c[i]);
        backtrack(i, c, t, ans, ls, sum+c[i]);
        ls.remove(ls.size()-1);
        backtrack(i+1, c, t, ans, ls, sum);
        
    }
}