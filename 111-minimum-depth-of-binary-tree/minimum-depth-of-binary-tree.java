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
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 1);

        return minDepth;
    }

    public void dfs(TreeNode root, int depth) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            minDepth = Math.min(depth, minDepth);
            return;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}