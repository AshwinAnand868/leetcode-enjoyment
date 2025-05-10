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
    public int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count = 0;

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            int avg = getSubtreeAvg(curr);
            if (curr.val == avg) {
                count++;
            }

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        return count;
    }

    private int getSubtreeAvg(TreeNode root) {
        int[] sum = {0};
        int[] count = {0};

        getSumSubtreeAndCountNodes(root, sum, count);

        return (int) sum[0]/count[0];
    }

    private void getSumSubtreeAndCountNodes(TreeNode root, int[] sum, int[] count) {
        if(root == null) return;

        sum[0] += root.val;
        count[0]++;

        getSumSubtreeAndCountNodes(root.left, sum, count);
        getSumSubtreeAndCountNodes(root.right, sum, count);
    }
}