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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < levelSize; ++i) {
                TreeNode curr = queue.poll();

                if(flag) {
                    level.add(curr.val);
                } else {
                    level.add(0, curr.val);
                }

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            flag = !flag;
            result.add(level);

        }

        // for(int i = 1; i < result.size(); i+=2) {
        //     Collections.reverse(result.get(i));
        // }

        return result;
    }

}