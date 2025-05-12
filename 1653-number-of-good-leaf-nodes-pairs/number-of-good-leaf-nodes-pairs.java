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

    public void buildGraphAndStoreLeafNodes(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> adjList, Set<TreeNode> leafNodes) {
        if(node == null) return;

        adjList.putIfAbsent(node, new ArrayList<>());

        if(node.left == null && node.right == null) {
            leafNodes.add(node);
        }

        if(parent != null) {
            adjList.putIfAbsent(parent, new ArrayList<>());
            adjList.get(node).add(parent);
            adjList.get(parent).add(node);
        }

        buildGraphAndStoreLeafNodes(node.left, node, adjList, leafNodes);
        buildGraphAndStoreLeafNodes(node.right, node, adjList, leafNodes);
    }


    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();

        buildGraphAndStoreLeafNodes(root, null, adjList, leafNodes);

        int count = 0;


        for(TreeNode leafNode : leafNodes) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.offer(leafNode);
            visited.add(leafNode);

            for(int level = 0; level <= distance; level++) {
                int size = queue.size();

                while(size-- > 0) {
                    TreeNode curr = queue.poll();

                    if(curr != leafNode && leafNodes.contains(curr)) {
                        count++;
                    }

                    for(TreeNode neighbour : adjList.getOrDefault(curr, new ArrayList<>())) {
                        if(!visited.contains(neighbour)) {
                            visited.add(neighbour);
                            queue.offer(neighbour);
                        }
                    }
                }
            }
        }

        return count / 2;

    }
}