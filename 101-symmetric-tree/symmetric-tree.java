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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root.left);
        q2.offer(root.right);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if(node1 == null && node2 == null) continue;

            if(node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            q1.offer(node1.left);
            q1.offer(node1.right);

            q2.offer(node2.right);
            q2.offer(node2.left);

        }

        return true;
    }
}