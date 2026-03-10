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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(list1, root1);

        List<Integer> list2 = new ArrayList<>();
        dfs(list2, root2);

        return list1.equals(list2);
    }

    public void dfs(List<Integer> leaves, TreeNode root) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }

        if(root.left != null) {
            dfs(leaves, root.left);
        }

        if(root.right != null) {
            dfs(leaves, root.right);
        }
    }
}