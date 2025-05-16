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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    public int[] dfs(TreeNode root) {
        if(root == null) return new int[] {0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int nodesCount = 1 + left[0] + right[0];
        int sum = root.val + left[1] + right[1];

        int avg = sum / nodesCount;

        if(root.val == avg) {
            count++;
        }

        return new int[]{nodesCount, sum};
    }
}