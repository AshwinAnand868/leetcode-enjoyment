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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean isEvenLevel = level % 2 == 0;

            int prev = isEvenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                if(isEvenLevel) {
                    if(curr.val <= prev || curr.val % 2 == 0) {
                        return false;
                    }
                } else {
                    if(curr.val >= prev || curr.val % 2 != 0) {
                        return false;
                    }
                }

                prev = curr.val;
                if(curr.left != null) {
                    queue.offer(curr.left);
                }

                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            level++;
        }

        return true;
    }
}