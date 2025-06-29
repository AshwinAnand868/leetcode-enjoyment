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
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        if(root.left != null) {
            TreeNode rightMost = root.left;
            while(rightMost.right != null) {
                rightMost = rightMost.right;
            }

            rightMost.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}