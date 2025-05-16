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
    long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        int totalSum = sumTotalNodes(root);
        calculateMaxProduct(root, totalSum);
        return (int)(maxProduct % 1_000_000_007);
    }

    private int sumTotalNodes(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumTotalNodes(root.left) + sumTotalNodes(root.right);
    }

    private int calculateMaxProduct(TreeNode node, int totalSum) {
        if (node == null) return 0;

        int leftSum = calculateMaxProduct(node.left, totalSum);
        int rightSum = calculateMaxProduct(node.right, totalSum);

        int subtreeSum = leftSum + rightSum + node.val;
        int complement = totalSum - subtreeSum;

        maxProduct = Math.max(maxProduct, (long)subtreeSum * complement);

        return subtreeSum;
    }
}
