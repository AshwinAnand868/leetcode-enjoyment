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
    public TreeNode searchBSTHelper(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        if(root.val == val) {
            return root;
        }
        
        if(root.val < val) {
            return searchBSTHelper(root.right, val);
        } else {
            return searchBSTHelper(root.left, val);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        return searchBSTHelper(root, val);
    }
}