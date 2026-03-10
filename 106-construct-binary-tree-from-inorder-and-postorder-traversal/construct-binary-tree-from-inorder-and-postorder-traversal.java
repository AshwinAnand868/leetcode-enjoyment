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

    int postorderIdx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length - 1;

        for(int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] postorder, int start, int end) {
        if(start > end || postorderIdx < 0) return null;

        int rootVal = postorder[postorderIdx];
        postorderIdx--;

        TreeNode root = new TreeNode(rootVal);

        int inorderRootIdx = inorderMap.get(rootVal);

        // first right as we are traversing the postorder array from backward
        root.right = buildTreeHelper(postorder, inorderRootIdx + 1, end);
        root.left = buildTreeHelper(postorder, start, inorderRootIdx - 1);

        return root;
    }
}