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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        Map<Integer, Integer> levelSum = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        // First BFS to compute sum at each level
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    sum += curr.left.val;
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    sum += curr.right.val;
                    queue.offer(curr.right);
                }
            }
            levelSum.put(level + 1, sum); // children are on next level
            level++;
        }

        // Second BFS to update node values
        queue.offer(root);
        root.val = 0;
        level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                int nextLevelSum = levelSum.getOrDefault(level + 1, 0);
                int siblingSum = 0;

                if (curr.left != null) siblingSum += curr.left.val;
                if (curr.right != null) siblingSum += curr.right.val;

                if (curr.left != null) {
                    curr.left.val = nextLevelSum - siblingSum;
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = nextLevelSum - siblingSum;
                    queue.offer(curr.right);
                }
            }

            level++;
        }

        return root;
    }
}
