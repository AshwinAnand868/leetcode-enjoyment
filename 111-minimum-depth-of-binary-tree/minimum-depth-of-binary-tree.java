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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            depth++;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                // return depth as soon as we encouncter the shortest path
                if (node.left == null && node.right == null)
                    return depth;

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return depth;
    }
}

// class Solution {
//     int minDepth = Integer.MAX_VALUE;

//     public int minDepth(TreeNode root) {
//         if(root == null) return 0;
//         minDepth(root, 1);
//         return minDepth;
//     }

//     public void minDepth(TreeNode root, int depth) {
//         if(root == null) return;

//         if(root.right == null && root.left == null) {
//             minDepth = Math.min(minDepth, depth);
//             return;
//         }

//         minDepth(root.left, depth + 1);
//         minDepth(root.right, depth + 1);
//     }
// }