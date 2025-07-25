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
    TreeNode first = null, middle = null, last = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Case 1: Non-adjacent nodes swapped
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // Case 2: Adjacent nodes swapped
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Find the first violation
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // Second violation
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }
}
