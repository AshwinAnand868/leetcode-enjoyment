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

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        return dfs(root, freq);    
    }

    public int dfs(TreeNode root, int[] freq) {
        if(root == null) return 0;

        freq[root.val]++;

        int count = 0;

        if(root.left == null && root.right == null) {
            if(isPseudoPalindrome(freq)) {
                count = 1;
            }
        } else {
            count += dfs(root.left, freq);
            count += dfs(root.right, freq);
        }

        freq[root.val]--;
        return count;
    }

    private boolean isPseudoPalindrome(int[] freq) {
        int oddCount = 0;
        for (int i = 1; i <= 9; ++i) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

}