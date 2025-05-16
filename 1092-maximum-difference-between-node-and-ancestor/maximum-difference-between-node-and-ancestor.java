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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    // do dfs while keeping track of the max and min encountered in the path
    public int dfs(TreeNode root, int max, int min) {
        if(root == null) {
            return max - min;
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        int left = dfs(root.left, max, min);
        int right = dfs(root.right, max, min);

        return Math.max(left, right);
    }
}