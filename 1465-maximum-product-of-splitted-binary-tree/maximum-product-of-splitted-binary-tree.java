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

    long SUM = 0;
    long maxP = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        SUM = getTotalSum(root);

        getMaxProduct(root);

        return (int)(maxP % MOD);
    }

    public long getTotalSum(TreeNode root) {
        if (root == null) return 0;

        long left = getTotalSum(root.left);
        long right = getTotalSum(root.right);

        return root.val + left + right;
    }

    public long getMaxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long leftSum = getMaxProduct(root.left);
        long rightSum = getMaxProduct(root.right);

        long subtreeSum = root.val + leftSum + rightSum;
        long complement = SUM - subtreeSum;

        maxP = Math.max(maxP, subtreeSum * complement);

        return subtreeSum;
    }
}
