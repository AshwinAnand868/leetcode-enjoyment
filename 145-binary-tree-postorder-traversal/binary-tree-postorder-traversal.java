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

        // Stack<TreeNode> stack1 = new Stack<>();



        // stack1.push(root);

        // Stack<TreeNode> stack2 = new Stack<>();

        // while(!stack1.isEmpty()) {
        //     TreeNode node = stack1.pop();
        //     stack2.push(node);

        //     if(node.left != null) {
        //         stack1.push(node.left);
        //     }

        //     if(node.right != null) {
        //         stack1.push(node.right);
        //     }
        // }

        // while(!stack2.isEmpty()) {
        //     result.add(stack2.pop().val);
        // }

        // return result;


        // List<Integer> result = new ArrayList<>();

        // if(root == null) {
        //     return result;
        // }

        // helper(root, result);
        // return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
        // if(root == null) {
        //     return;
        // }

        // helper(root.left, result);
        // helper(root.right, result);
        // result.add(root.val);
    }
}