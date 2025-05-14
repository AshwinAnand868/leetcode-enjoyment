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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.offer(root);

        List<Integer> result = new ArrayList<>();

        while(!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();

            for(int i = 0; i < size; ++i) {
                TreeNode curr = nodesQueue.poll();

                if(i == size - 1) {
                    result.add(curr.val);
                }

                if(curr.left != null) nodesQueue.offer(curr.left);
                if(curr.right != null) nodesQueue.offer(curr.right);
            }
        }

        return result;
    }
}