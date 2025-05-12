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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<Integer, int[]> map = new HashMap<>();
        map.put(root.val, new int[]{-1, 0}); 
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    map.put(curr.left.val, new int[]{curr.val, level + 1});
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    map.put(curr.right.val, new int[]{curr.val, level + 1});
                    queue.offer(curr.right);
                }
            }

            level++;
        }

        int[] xArr = map.get(x);
        int[] yArr = map.get(y);

        return xArr[0] != yArr[0] && xArr[1] == yArr[1];
    }
}
