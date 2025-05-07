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
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode node, int currMin, int currMax) {
        if (node == null) return;

        // Update min and max seen so far
        currMin = Math.min(currMin, node.val);
        currMax = Math.max(currMax, node.val);

        maxDiff = Math.max(maxDiff, currMax - currMin);

        // Recurse left and right
        dfs(node.left, currMin, currMax);
        dfs(node.right, currMin, currMax);
    }
}
