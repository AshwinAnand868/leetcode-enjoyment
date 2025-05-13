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
        flattenHelper(root);
    }

    public TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;

        // leaf is already flattened
        if (root.right == null && root.left == null) return root;

        TreeNode rootLeftFlattened = flattenHelper(root.left);
        root.left = null;

        TreeNode curr = rootLeftFlattened;

        if (root.right != null) {
            TreeNode rootRightFlattened = flattenHelper(root.right);

            // check if curr is not null before dereferencing
            if (curr != null) {
                root.right = rootLeftFlattened;

                while (curr.right != null) {
                    curr = curr.right;
                }

                curr.right = rootRightFlattened;
            } else {
                // No left subtree, attach right subtree directly
                root.right = rootRightFlattened;
            }
        } else {
            root.right = rootLeftFlattened;
        }

        return root;
    }
}
