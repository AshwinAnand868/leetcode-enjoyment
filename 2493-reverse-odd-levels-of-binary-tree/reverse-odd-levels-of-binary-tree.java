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
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelsHelper(root.left, root.right, 1);
        return root;
    }

    private void reverseOddLevelsHelper(TreeNode left, TreeNode right, int level) {
        if(left == null) {
            return;
        }

        if(level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        reverseOddLevelsHelper(left.left, right.right, level + 1);
        reverseOddLevelsHelper(left.right, right.left, level + 1);        
    }
}