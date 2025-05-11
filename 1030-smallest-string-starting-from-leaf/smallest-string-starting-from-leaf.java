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
    String smallestFromLeaf = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallestFromLeaf;
    }

    public void dfs(TreeNode root, StringBuilder curr) {
        if(root == null) return;

        curr.insert(0, (char) (root.val + 'a'));

        if(root.left == null && root.right == null) {
            if(smallestFromLeaf.compareTo(curr.toString()) > 0 || smallestFromLeaf.equals("")) {
                smallestFromLeaf = curr.toString();
            }
            curr.deleteCharAt(0);
            return;
        }

        dfs(root.left, curr);
        dfs(root.right, curr);

        curr.deleteCharAt(0);
    }
}