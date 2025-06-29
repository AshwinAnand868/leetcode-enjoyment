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
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        List<TreeNode> sorted = new ArrayList<>(nodes);
        sorted.sort((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).val != sorted.get(i).val) {
                int temp = nodes.get(i).val;
                nodes.get(i).val = sorted.get(i).val;
                sorted.get(i).val = temp;
                break;
            }
        }
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        // if (root == null) return;
        // inorder(root.left, nodes);
        // nodes.add(root);
        // inorder(root.right, nodes);
        if(root == null) return;

        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                nodes.add(curr);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;

                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    nodes.add(curr);
                    curr = curr.right;
                }
            }
        }
    }
}