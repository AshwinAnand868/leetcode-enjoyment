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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allLevelValues = new ArrayList<>();
        Queue<TreeNode> currLevelQueue = new LinkedList<>();
        if(root == null) return allLevelValues;

        currLevelQueue.offer(root);

        while(!currLevelQueue.isEmpty()) {
            int size = currLevelQueue.size();
            List<Integer> currLevelValues = new ArrayList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode curr = currLevelQueue.poll();
                currLevelValues.add(curr.val);
                if(curr.left != null) {
                    currLevelQueue.offer(curr.left);
                } 
                
                if(curr.right != null) {
                    currLevelQueue.offer(curr.right);
                }
            }

            allLevelValues.add(currLevelValues);
        }
        return allLevelValues;
    }
}