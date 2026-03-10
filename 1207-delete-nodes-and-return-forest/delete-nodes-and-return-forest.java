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

    public TreeNode helper(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if(root == null) return null;

        // go deep left
        root.left = helper(root.left, toDeleteSet, result);

        // go deep right
        root.right = helper(root.right, toDeleteSet, result);

        if(toDeleteSet.contains(root.val)) {
            // check its left and right
            if(root.left != null) {
                result.add(root.left);
            }            

            if(root.right != null) {
                result.add(root.right);
            }

            return null; // curr root to be deleted
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();

        for(int val : to_delete) {
            toDeleteSet.add(val);
        }

        helper(root, toDeleteSet, result);

        if(!toDeleteSet.contains(root.val)) {
            result.add(root);
        }

        return result;
    }
}