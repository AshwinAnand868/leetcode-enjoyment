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

    public void buildLargestValues(TreeNode root, List<Integer> result, int depth) {
        if(root == null) return;

        // visiting this depth for the first time
        if(result.size() == depth) {
            result.add(root.val);
        } else {
            // visiting the depth for the 2nd time, means
            // there is already a value at that index.
            // compare both values and set the greater
            int current = result.get(depth);
            result.set(depth, Math.max(current, root.val));
        }

        buildLargestValues(root.left, result, depth + 1);
        buildLargestValues(root.right, result, depth + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        buildLargestValues(root, result, 0);
        return result;

        // BFS
        // Queue<TreeNode> queue = new ArrayDeque<>();
        // queue.offer(root);

        // while (!queue.isEmpty()) {
        //     int n = queue.size();
        //     // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap
        //     int max = Integer.MIN_VALUE;

        //     while (n-- > 0) {
        //         TreeNode current = queue.poll();
        //         // pq.offer(current.val);
        //         max = Math.max(max, current.val);

        //         if (current.left != null) {
        //             queue.offer(current.left);
        //         }

        //         if (current.right != null) {
        //             queue.offer(current.right);
        //         }
        //     }

        //     // int max = pq.poll();
        //     result.add(max);
        // }

        // return result;
    }
}