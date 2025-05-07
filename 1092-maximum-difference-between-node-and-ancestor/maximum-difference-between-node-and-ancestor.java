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
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int[] minMax = getMinMax(node);  // DFS to get min and max in subtree
            int minVal = minMax[0];
            int maxVal = minMax[1];

            maxDiff = Math.max(maxDiff, Math.abs(node.val - minVal));
            maxDiff = Math.max(maxDiff, Math.abs(node.val - maxVal));

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return maxDiff;
    }

    public int[] getMinMax(TreeNode node) {
        int min = node.val;
        int max = node.val;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if(curr != node) {
                min = Math.min(min, curr.val);
                max = Math.max(max, curr.val);
            }

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }

        return new int[] {min, max};
    }
}