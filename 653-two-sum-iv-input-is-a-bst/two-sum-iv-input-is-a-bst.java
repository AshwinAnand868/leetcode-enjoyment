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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);

        int i = 0;
        int j = vals.size() - 1;

        while( i < j) {
            int currentSum = vals.get(i) + vals.get(j);
            
            if(currentSum == k) {
                return true;
            } else if(currentSum < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if(root ==  null) return;

        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }
}