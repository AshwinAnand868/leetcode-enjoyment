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

    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preorderIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(0, inorder.length, preorder);
    }

    public TreeNode buildTreeHelper(int start, int end, int[] preorder) {
        if(start > end || preorderIdx >= preorder.length) return null;

        int rootVal = preorder[preorderIdx];
        preorderIdx++;
        TreeNode root = new TreeNode(rootVal);

        int rootIdxInInorderMap = inorderMap.get(rootVal);

        root.left = buildTreeHelper(start, rootIdxInInorderMap - 1, preorder);
        root.right = buildTreeHelper(rootIdxInInorderMap + 1, end, preorder);

        return root;
    }
}