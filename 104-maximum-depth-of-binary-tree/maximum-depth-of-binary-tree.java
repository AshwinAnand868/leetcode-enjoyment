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
    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int leftHand = maxDepth(root.left);
        int rightHand = maxDepth(root.right);

        return 1 + Math.max(leftHand, rightHand);

        // int depth = 0;
        // Queue<TreeNode> levelsQueue = new LinkedList<>();

        // if(root == null) return 0;

        // levelsQueue.offer(root);

        // while(!levelsQueue.isEmpty()) {
        //     int size = levelsQueue.size();
        //     depth++;

        //     for(int i = 0; i < size; ++i) {
        //         TreeNode curr = levelsQueue.poll();
        //         if(curr.left != null) {
        //             levelsQueue.offer(curr.left);
        //         }

        //         if(curr.right != null) {
        //             levelsQueue.offer(curr.right);
        //         }
        //     }
        // }

        // return depth;

    }
}