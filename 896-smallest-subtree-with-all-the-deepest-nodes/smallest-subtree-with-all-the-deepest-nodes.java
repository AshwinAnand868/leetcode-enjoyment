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
    int maxDepth = 0;
    Map<Integer, Integer> nodeValToDepth = new HashMap<>();

    private void depth(TreeNode root, int depth) {
        if(root == null) return;

        if(depth > maxDepth) {
            maxDepth = depth;
        }

        nodeValToDepth.put(root.val, depth);

        depth(root.left, depth + 1);
        depth(root.right, depth + 1);
    }

    public TreeNode lca(TreeNode root) {
        if(root == null || nodeValToDepth.get(root.val) == maxDepth) { // if root null or this is deepest level/leaf
            return root;
        }

        TreeNode left = lca(root.left);
        TreeNode right = lca(root.right);

        if(left != null && right != null) {
            return root;
        }

        if(left != null) {
            return left;
        }

        return right;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root,0);
        return lca(root);
    }
}