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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = root.val;
        int level = 1;
        int currentLevel = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int runningSum = 0;

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();
                runningSum += curr.val;

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            if(runningSum > maxSum) {
                maxSum = runningSum;
                level = currentLevel;
            }

            currentLevel++;
        }

        return level;
    }
}