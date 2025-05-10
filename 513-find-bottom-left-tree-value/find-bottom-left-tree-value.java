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
    private int maxDepth = 0;
    private int leftMostValue = -1;

    private void dfs(TreeNode root, int depth) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            if(depth > maxDepth) {
                maxDepth = depth;
                leftMostValue = root.val;
            }
            return;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return leftMostValue;
        // int bottomLeft = -1;

        // if(root == null) return -1;

        // Queue<TreeNode> queue = new LinkedList<>();

        // queue.offer(root);

        // while(!queue.isEmpty()) {
        //     int size = queue.size();
        //     for(int i = 0; i < size; ++i) {
        //         TreeNode curr = queue.poll();

        //         if(i == 0) {
        //             bottomLeft = curr.val;
        //         }

        //         if(curr.left != null) {
        //             queue.offer(curr.left);
        //         }

        //         if(curr.right != null) {
        //             queue.offer(curr.right);
        //         }
        //     }
        // }

        // return bottomLeft;
    }
}