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

        List<TreeNode> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr);

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        int count = 0;
        for(int i = 0; i < list.size(); ++i) {
            TreeNode curr = list.get(i);

            int avg = getSubtreeAvg(curr);
            if (curr.val == avg) {
                count++;
            }
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

    // private int countNodesEqualToAvg(TreeNode curr, int avg) {
    //     int[] count = {0};
    //     countNodesEqualToAvgHelper(curr, avg, count);
    //     return count[0];
    // }

    // private void countNodesEqualToAvgHelper(TreeNode curr, int avg, int[] count) {
    //     if(curr == null) return;

    //     if(curr.val == avg) {
    //         count[0]++;
    //     }

    //     countNodesEqualToAvgHelper(curr.left, avg, count);
    //     countNodesEqualToAvgHelper(curr.right, avg, count);
    // }
}