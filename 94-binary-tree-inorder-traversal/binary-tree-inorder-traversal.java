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
    // Using morris traversal logic without extra memory
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                // print root or curr, move to right side
                result.add(curr.val);
                curr = curr.right;
            } else {
                // go to the right most part of the left subtree
                TreeNode prev = curr.left;

                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if(prev.right == null) { // no thread exists - create the thread
                    prev.right = curr;
                    curr = curr.left; // visit teh left side
                } else {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right; // visit the right side as left is done
                }
            }
        }

        return result;
    }
}