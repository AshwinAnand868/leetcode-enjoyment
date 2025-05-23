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
class FindElements {

    TreeNode root = null;
    HashSet<Integer> elements = new HashSet<>();

    public FindElements(TreeNode root) {
        this.root = root;
        recoverBinaryTree(this.root);
    }

    private void recoverBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        elements.add(root.val);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                curr.left.val = 2 * curr.val + 1;
                elements.add(curr.left.val);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                curr.right.val = 2 * curr.val + 2;
                elements.add(curr.right.val);
                queue.offer(curr.right);
            }
        }

        // if(root == null) return;

        // root.val = val;
        // elements.add(root.val);

        // recoverBinaryTree(root.left, root.val * 2 + 1);
        // recoverBinaryTree(root.right, root.val * 2 + 2);
    }

    public boolean find(int target) {
        return elements.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */