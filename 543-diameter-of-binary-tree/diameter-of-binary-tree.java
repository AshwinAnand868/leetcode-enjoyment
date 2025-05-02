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

    int maxHeight = 0;

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        maxHeight = Math.max(maxHeight, lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        maxDepth(root);
        return maxHeight;

        // brute force is to get max depth - height of every node - n^2
        // diameterOfBinaryTree(root.left);
        // diameterOfBinaryTree(root.right);

        // return maxHeight;
    }
}