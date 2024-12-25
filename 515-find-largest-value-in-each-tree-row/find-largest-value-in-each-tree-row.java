/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap

            while (n-- > 0) {
                TreeNode current = queue.poll();
                pq.offer(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            int max = pq.poll();
            result.add(max);
        }

        return result;
    }
}