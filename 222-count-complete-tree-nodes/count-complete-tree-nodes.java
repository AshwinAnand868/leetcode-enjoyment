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
        // return dfs(root);
        if(root == null) return 0;

        int leftHeight = getDepth(root.left, true);
        int rightDepth = getDepth(root.right, false);

        // if left and right depths are equal, we know it is a balanced tree
        if(leftHeight == rightDepth) {
            return (int) Math.pow(2, leftHeight + 1) - 1;
        }

        // otherwise count the nodes in the left and right side of the node
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getDepth(TreeNode root, boolean isLeft) {
        TreeNode temp = root;
        int height = 0;

        while (temp != null) {
            temp = isLeft ? temp.left : temp.right;
            height++;
        }

        return height;
    }


    // private int dfs(TreeNode root) {
        // if (root == null) return 0;

        // int lc = dfs(root.left);
        // int rc = dfs(root.right);

        // return 1 + lc + rc;
    // }
}
