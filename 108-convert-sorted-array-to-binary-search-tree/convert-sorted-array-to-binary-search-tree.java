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

    private TreeNode makeBST(int[] nums, int start, int end) {
        if(start > end) { // base case like binary search
            return null;
        }

        // first we find the mid of the array to make it the root of balanced binary tree

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = makeBST(nums, start, mid - 1); // process left of the root
        root.right = makeBST(nums, mid + 1, end); // process right of the root

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }
}