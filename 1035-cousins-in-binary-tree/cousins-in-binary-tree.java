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

        TreeNode xParent = null, yParent = null;
        int xDepth = -1, yDepth = -1;
        int depth = 0;
        boolean breakLoop = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                if(curr.right != null) {
                    if(curr.right.val == x) {
                        xParent = curr;
                        xDepth = depth;
                    }
                    if(curr.right.val == y) {
                        yParent = curr;
                        yDepth = depth;
                    }
                    queue.offer(curr.right);
                }

                if(curr.left != null) {
                    if(curr.left.val == x) {
                        xParent = curr;
                        xDepth = depth;
                    }
                    if(curr.left.val == y) {
                        yParent = curr;
                        yDepth = depth;
                    }
                    queue.offer(curr.left);
                }

                if(xParent != null && yParent != null) {
                    breakLoop = true;
                }
            }

            if(breakLoop) {
                break;
            }

            depth++;
        }
        if(xParent == null || yParent == null) return false;
        return xParent.val != yParent.val && xDepth == yDepth;
    }
}