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
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {

            // store the left most elements
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // process the node
            curr = stack.pop();
            result.add(curr.val);

            // move curr to its right (explore its right)
            curr = curr.right;            
        }

        // // Using recursion
        // inorderTraversalHelper(root, result);

        return result;
    }

    public void inorderTraversalHelper(TreeNode root, List<Integer> result) {

        if(root == null) return;

        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
}