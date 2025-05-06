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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            if(currentDepth == depth - 1) {
                for(int i = 0; i < size; ++i) {
                    TreeNode node = queue.poll();

                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    node.left = new TreeNode(val);
                    node.left.left = left;

                    node.right = new TreeNode(val);
                    node.right.right = right;
                }

                break;
            }


            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            currentDepth++;
        }

        return root;
    }
}