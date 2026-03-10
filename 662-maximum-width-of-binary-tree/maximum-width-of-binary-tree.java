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

class Pair {
    int index;
    TreeNode node;

    Pair() {}
    Pair(TreeNode node, int index) {
        this.index = index;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int lastIndex = 0, firstIndex = 0;
            // int minIndex = 0;
            
            for(int i = 0; i < size; ++i) {
                Pair pair = queue.poll();
                TreeNode curr = pair.node;

                if(i == 0) {
                    firstIndex = pair.index;
                }

                if(i == size - 1) {
                    lastIndex = pair.index;
                }

                if(curr.left != null) {
                    queue.offer(new Pair(curr.left, 2 * pair.index + 1));
                }
                if(curr.right != null) {
                    queue.offer(new Pair(curr.right, 2 * pair.index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
}