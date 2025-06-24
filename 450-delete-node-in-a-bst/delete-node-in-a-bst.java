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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // node to delete is found
            if(root.right == null) {
                return root.left;
            }
            
            if(root.left == null) {
                return root.right;
            }

            // both children are present
            // find inorder successor
            TreeNode succ = getSuccessor(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }

        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        while(root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }
}