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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        TreeNode prev = null;

        while(!stack.isEmpty() || current != null) {
            // go to left as left as possible
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peekNode = stack.peek();

            if(peekNode.right != null && peekNode.right != prev) {
                current = peekNode.right;
            } else {
                result.add(peekNode.val);
                prev = stack.pop();
            }
        }

        return result;
    }
}