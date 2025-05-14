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
    Map<Integer, Integer> postorderMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for(int i = 0; i < postorder.length; ++i) {
            postorderMap.put(postorder[i], i);
        }
        return construct(0, n - 1, 0, preorder, postorder);
    }

    private TreeNode construct(int preorderStart, int preorderEnd, int postorderStart, int[] preorder, int[] postorder) {
        if(preorderStart > preorderEnd) return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);

        if(preorderStart == preorderEnd) {
            return root; // leaf node - no next node after this
        }

        int nextVal = preorder[preorderStart + 1];

        int j = postorderMap.get(nextVal);

        // while(postorder[j] != nextVal) {
        //     j++;
        // }

        int numNodes = j - postorderStart + 1;

        root.left = construct(preorderStart + 1, preorderStart + numNodes, postorderStart, preorder, postorder);
        root.right = construct(preorderStart + numNodes + 1, preorderEnd, j + 1, preorder, postorder);

        return root;
    }
}