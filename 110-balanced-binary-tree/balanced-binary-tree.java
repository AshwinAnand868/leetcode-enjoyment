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
    public boolean isBalanced(TreeNode root) { 
        boolean[] continuee = {true};
        helper(root, continuee);
        return continuee[0];
    }

    public void helper(TreeNode root, boolean[] continuee) {
        if(root == null) return;

        if(continuee[0] == false) {
            return;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        if(Math.abs(lh - rh) > 1) {
            continuee[0] = false;
            return;
        }

        helper(root.left, continuee);
        helper(root.right, continuee);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh, rh);
    }
}