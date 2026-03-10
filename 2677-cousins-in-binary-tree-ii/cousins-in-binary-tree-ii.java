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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        Map<Integer, Integer> levelSum = new HashMap<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for(int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                    sum += node.left.val;
                }

                if(node.right != null) {
                    queue.offer(node.right);
                    sum += node.right.val;
                }
            }

            levelSum.put(level + 1, sum);
            level++;
        }

        queue.offer(root);
        root.val = 0;
        level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();
                int levelKaSum = levelSum.get(level + 1);

                int siblingKaSum = 0;

                if(curr.left != null) {
                    siblingKaSum += curr.left.val;
                }

                if(curr.right != null) {
                    siblingKaSum += curr.right.val;
                }

                if(curr.left != null) {
                    curr.left.val = levelKaSum - siblingKaSum;
                    queue.offer(curr.left);
                }

                if(curr.right != null) {
                    curr.right.val = levelKaSum - siblingKaSum;
                    queue.offer(curr.right);
                }
            }

            level++;
        }

        return root;
    }
}