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
    HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        populateChildToParentMap(root);

        TreeNode st = findStartNode(root, start);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(st);

        Set<TreeNode> infected = new HashSet<>();
        infected.add(st);

        int minutes = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                if(curr.left != null && !infected.contains(curr.left)) {
                    queue.offer(curr.left);
                    infected.add(curr.left);
                }

                if(curr.right != null && !infected.contains(curr.right)) {
                    queue.offer(curr.right);
                    infected.add(curr.right);
                }

                if(childToParent.get(curr) != null && !infected.contains(childToParent.get(curr))) {
                    queue.offer(childToParent.get(curr));
                    infected.add(childToParent.get(curr));
                }
            }
            if(!queue.isEmpty()) {
                minutes++;
            }
        }

        return minutes;
    }

    private TreeNode findStartNode(TreeNode root, int start) {
        if(root == null) return null;
        if(root.val == start) {
            return root;
        }

        // find in the left subtree
        TreeNode leftResult  = findStartNode(root.left, start);
        if(leftResult  != null) { // start node is this left one
            return leftResult;
        }

        // Else search in the right subtree
        return findStartNode(root.right, start);
    }

    private void populateChildToParentMap(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            childToParent.put(root.left, root);
        }


        if(root.right != null) {
            childToParent.put(root.right, root);
        }

        populateChildToParentMap(root.left);
        populateChildToParentMap(root.right);
    }
}