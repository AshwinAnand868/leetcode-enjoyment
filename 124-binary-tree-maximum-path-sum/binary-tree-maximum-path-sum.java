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

    int maximumSum;

    public int maxPathSum(TreeNode root) {
        maximumSum = Integer.MIN_VALUE;
        maxSum(root);
        return maximumSum;
    }

    private int maxSum(TreeNode root) {
       if(root == null) {
        return 0;
       }

       int lh = maxSum(root.left);
       int rh = maxSum(root.right);

       int foundAnswerInDownOnly = lh + rh + root.val;

       int eitherLeftOrRightGood = Math.max(lh, rh) + root.val;

       int onlyRootGood = root.val;

       maximumSum = Math.max(maximumSum, foundAnswerInDownOnly);
       maximumSum = Math.max(maximumSum, eitherLeftOrRightGood);
       maximumSum = Math.max(maximumSum, onlyRootGood);

       // explore only root good or left/right good - 2 paths only
       return Math.max(onlyRootGood, eitherLeftOrRightGood);
    }
}