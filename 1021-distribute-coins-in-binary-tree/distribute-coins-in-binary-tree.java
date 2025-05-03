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
    int moves = 0;

    public int solve(TreeNode root) {
        if(root == null) return 0;

        int lh = solve(root.left);
        int rh = solve(root.right);

        moves += Math.abs(lh) + Math.abs(rh);

        return lh + rh + root.val - 1;
    }
    
    public int distributeCoins(TreeNode root) {
        if(root == null) return moves;

        solve(root);
        return moves;
    }
}