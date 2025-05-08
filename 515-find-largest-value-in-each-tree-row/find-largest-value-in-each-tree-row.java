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
    public List<Integer> largestValues(TreeNode root) {

        if(root == null) return new ArrayList<>();

        // BST
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                max = Math.max(max, curr.val);

                if(curr.left != null) {
                    queue.offer(curr.left);
                } 
                
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            result.add(max);
        }

        return result;
    }
}