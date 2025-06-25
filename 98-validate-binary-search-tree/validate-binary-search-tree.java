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
    public boolean isValidBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();

        inorder(root, vals);

        for(int i = 0; i < vals.size() - 1; ++i) {
            if(vals.get(i) >= vals.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if(root == null) return;

        inorder(root.left, vals);

        vals.add(root.val);

        inorder(root.right, vals);
    }
}