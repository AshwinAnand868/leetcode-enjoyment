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
import java.util.*;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Map<Integer, Stack<Integer>> levelMap = new HashMap<>();

        // First BFS to collect values at odd levels
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 1) {
                    stack.push(node.val);  // Store in stack to reverse later
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (level % 2 == 1) {
                levelMap.put(level, stack);
            }

            level++;
        }

        // Second BFS to update odd levels from stack
        queue.offer(root);
        level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 1) {
                    // Pop from corresponding stack
                    node.val = levelMap.get(level).pop();
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            level++;
        }

        return root;
    }
}
