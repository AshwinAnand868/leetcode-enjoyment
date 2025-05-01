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
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }
    
        // Using stack
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);

            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left); // pushing left later to access left at the top
        }

        return result;

        // Using recursion

        // List<Integer> result = new ArrayList<>();
        // preorderTraversalHelper(root, result);

        // return result;
    }

    public void preorderTraversalHelper(TreeNode root, List<Integer> result) {

        if(root == null) return;

        result.add(root.val);
        preorderTraversalHelper(root.left, result);
        preorderTraversalHelper(root.right, result);
    }
}