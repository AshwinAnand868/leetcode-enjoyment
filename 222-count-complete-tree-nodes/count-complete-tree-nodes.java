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
    public int countNodes(TreeNode root) {
        return countNodesHelper(root);
    }

    public int countNodesHelper(TreeNode root) {
        if(root == null) return 0;

        // count nodes in left subtree
        int left = getHeight(root.left, true);
        int right = getHeight(root.right, false);

        if(left == right) {
            return (int) Math.pow(2, left + 1) - 1;
        }

        return 1 + countNodesHelper(root.left) + countNodesHelper(root.right);
    }

    public int getHeight(TreeNode root, boolean isLeft) {
        TreeNode temp = root;
        int height = 0;

        while(temp != null) {
            temp = isLeft ? temp.left : temp.right;
            height++;
        }

        return height;
    }
}