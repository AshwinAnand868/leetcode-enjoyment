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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode xParent = null, yParent = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    if (curr.left.val == x) xParent = curr;
                    if (curr.left.val == y) yParent = curr;
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    if (curr.right.val == x) xParent = curr;
                    if (curr.right.val == y) yParent = curr;
                    queue.offer(curr.right);
                }
            }

            // Both found at same level
            if (xParent != null && yParent != null) {
                return xParent != yParent; // same level, different parent
            }

            // Found only one at this level
            if (xParent != null || yParent != null) {
                return false;
            }
        }

        return false;
    }
}
