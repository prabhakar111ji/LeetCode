/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long total = 0;
    long max = Integer.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        total = dfs(root);
        dfs(root);
        max%=1000000007;
        return (int)max;
    }
    private long dfs(TreeNode node){
        if(node == null)return 0;
        long left =dfs(node.left);
        long right = dfs(node.right);
        long st = left + right + node.val;
        max = Math.max(st*(total-st),max);
        return st;
    } 
}