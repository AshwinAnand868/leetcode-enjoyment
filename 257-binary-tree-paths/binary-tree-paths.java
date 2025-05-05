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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, List<String> result, List<Integer> path) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); ++i) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
            path.remove(path.size() - 1);
            return;
        }

        if (root.left != null) {
            path.add(root.val);
            helper(root.left, result, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.val);
            helper(root.right, result, path);
            path.remove(path.size() - 1);
        }
    }
}
