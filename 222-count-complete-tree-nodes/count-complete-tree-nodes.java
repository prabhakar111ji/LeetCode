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
    public int lh(TreeNode r){
        int h = 0;
        while(r!=null){
            h++;
            r = r.left;
        }
        return h;
    }
    public int rh(TreeNode r){
        int h = 0;
        while(r!=null){
            h++;
            r = r.right;
        }
        return h;
    }
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        int l = lh(root);
        int r = rh(root);
        if(l == r)return (1<<l)-1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}