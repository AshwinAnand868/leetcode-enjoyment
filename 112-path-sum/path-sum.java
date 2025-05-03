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
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        solve(root, targetSum, root.val);
        return hasPath;
    }

    public void solve(TreeNode root, int targetSum, int sum) {

        if(hasPath) return;

        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                hasPath = true;
            }
            return;
        }

        if(!hasPath) {
            if(root.left != null) {
                solve(root.left, targetSum, sum + root.left.val);
            }
            
            if(root.right != null) {
                solve(root.right, targetSum, sum + root.right.val);
            }
        }
    }
}