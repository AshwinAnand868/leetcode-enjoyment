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

        sumNumbersHelper(root, new StringBuilder());
        return maxSum;
    }

    public void sumNumbersHelper(TreeNode root, StringBuilder sb) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            sb.append(root.val);
            int currNum = Integer.parseInt(sb.toString());
            maxSum += currNum;
            sb.setLength(sb.length() - 1);
            return;
        } 

        sb.append(root.val);

        sumNumbersHelper(root.left, sb);
        sumNumbersHelper(root.right, sb);

        sb.setLength(sb.length() - 1);
    }
}