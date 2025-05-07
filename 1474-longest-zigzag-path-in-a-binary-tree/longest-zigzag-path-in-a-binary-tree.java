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

    private int maxLen = 0;

    public void dfs(TreeNode root, boolean goLeft, int length) {
        if(root == null) return;

        maxLen = Math.max(maxLen, length);

        if(goLeft) {
            dfs(root.left, false, length + 1); // current zig zag path
            dfs(root.right, true, 1); // finding next fresh zig zag path
        } else {
            dfs(root.right, true, length + 1);
            dfs(root.left, false, 1);
        }

    }

    public int longestZigZag(TreeNode root) {

        if(root == null) return 0;

        dfs(root.left, false, 1);
        dfs(root.right, true, 1);

        return maxLen;



        // if (root == null) return 0;

        // int maxLen = 0;

        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);

        // while (!queue.isEmpty()) {
        //     TreeNode curr = queue.poll();

        //     if (curr.left != null) queue.offer(curr.left);
        //     if (curr.right != null) queue.offer(curr.right);

        //     maxLen = Math.max(maxLen, findZigZagPath(curr.left, false)); // Go right next
        //     maxLen = Math.max(maxLen, findZigZagPath(curr.right, true)); // Go left next
        // }

        // return maxLen;
    }

    public int findZigZagPath(TreeNode root, boolean goLeft) {
        if(root == null) return 0;

        int left = 0, right = 0;

        if(goLeft) {
            left = findZigZagPath(root.left, false);
        } else {
            right = findZigZagPath(root.right, true);
        }

        return Math.max(left, right) + 1;
    }
}