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

    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    Map<Integer, TreeNode> valueToNode = new HashMap<>();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        buildParentMap(root, null);

        TreeNode startNode = valueToNode.get(startValue);
        TreeNode destNode = valueToNode.get(destValue);

        StringBuilder path = new StringBuilder();
        Set<TreeNode> visited = new HashSet<>();
        dfs(startNode, destNode, visited, path);

        return path.toString();
    }

    public void buildParentMap(TreeNode node, TreeNode parent) {
        if(node == null) return;

        parentMap.put(node, parent);
        valueToNode.put(node.val, node);

        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

        private boolean dfs(TreeNode current, TreeNode target, Set<TreeNode> visited, StringBuilder path) {
        if (current == null || visited.contains(current)) return false;
        if (current == target) return true;

        visited.add(current);

        if (dfs(current.left, target, visited, path)) {
            path.insert(0, 'L');
            return true;
        }

        if (dfs(current.right, target, visited, path)) {
            path.insert(0, 'R');
            return true;
        }

        TreeNode parent = parentMap.get(current);
        if (dfs(parent, target, visited, path)) {
            path.insert(0, 'U');
            return true;
        }

        return false;
    }

}