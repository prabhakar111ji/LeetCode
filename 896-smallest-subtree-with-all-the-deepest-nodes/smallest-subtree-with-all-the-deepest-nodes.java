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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private Pair dfs(TreeNode n) {
        if (n == null) return new Pair(null, 0);
        Pair l = dfs(n.left);
        Pair r = dfs(n.right);
        if (l.dist > r.dist) return new Pair(l.node, l.dist + 1);
        if (r.dist > l.dist) return new Pair(r.node, r.dist + 1);
        return new Pair(n, l.dist + 1);
    }
    
    class Pair {
        TreeNode node;
        int dist;
        Pair(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }
}