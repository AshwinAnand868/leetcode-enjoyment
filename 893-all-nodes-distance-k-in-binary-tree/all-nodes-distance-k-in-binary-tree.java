/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();

    public void populateParentMap(TreeNode root) {
        if(root == null) return;

        if(root.left != null) {
            childToParentMap.put(root.left, root);
        }

        populateParentMap(root.left);

        if(root.right != null) {
            childToParentMap.put(root.right, root);
        }

        populateParentMap(root.right);
    }

    public void solveUsingBFS(List<Integer> result, TreeNode root, int k) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<Integer> visited = new HashSet<>();
        visited.add(root.val);

        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            if(level == k) {
                break;
            }

            for(int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();

                if(curr.left != null && !visited.contains(curr.left.val)) {
                    queue.offer(curr.left);
                    visited.add(curr.left.val);
                }

                if(curr.right != null && !visited.contains(curr.right.val)) {
                    queue.offer(curr.right);
                    visited.add(curr.right.val);
                }

                TreeNode parent = childToParentMap.get(curr);
                if(parent != null && !visited.contains(parent.val)) {
                    queue.offer(parent);
                    visited.add(parent.val);
                }
            }

            level++;
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        populateParentMap(root);

        solveUsingBFS(result, target, k);

        return result;
    }
}