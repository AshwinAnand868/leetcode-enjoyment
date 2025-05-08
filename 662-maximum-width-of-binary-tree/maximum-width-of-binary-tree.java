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
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Deque<Pair> deque = new LinkedList<>();

        deque.offerLast(new Pair(root, 0));
        int maxWidth = 0;

        while(!deque.isEmpty()) {
            int size = deque.size();
            int first = deque.peekFirst().index;
            int last = deque.peekLast().index;
            maxWidth = Math.max(maxWidth, last - first + 1);

            for(int i = 0; i < size; ++i) {
                TreeNode curr = deque.peek().node;
                int idx = deque.peek().index;
                deque.poll();

                if(curr.left != null) {
                    deque.offerLast(new Pair(curr.left, 2 * idx + 1));
                }
                if(curr.right != null) {
                    deque.offerLast(new Pair(curr.right, 2 * idx + 2));
                }
            }

           
        }
        return maxWidth;
    }
}