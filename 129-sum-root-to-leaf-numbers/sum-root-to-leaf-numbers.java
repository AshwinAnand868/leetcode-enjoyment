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

    int maxSum = 0;

    public int sumNumbers(TreeNode root) {
        
        if(root == null) return 0;

        sumNumbersHelper(root, 0);
        return maxSum;
    }

    public void sumNumbersHelper(TreeNode root, int current) {
        if(root == null) return;
        
        current = current * 10 + root.val;

        if(root.left == null && root.right == null) {
            maxSum += current;
            return;
        } 

        sumNumbersHelper(root.left, current);
        sumNumbersHelper(root.right, current);
    }
}