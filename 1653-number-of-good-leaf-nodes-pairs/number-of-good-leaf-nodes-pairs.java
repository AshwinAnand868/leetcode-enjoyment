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

    public void buildGraphAndCollectLeafNodes(Map<TreeNode, List<TreeNode>> adjList, Set<TreeNode> leaves, TreeNode node, TreeNode neighbour) {
        if(node == null) return;

        if(node.left == null && node.right == null) {
            leaves.add(node);
        }

        adjList.putIfAbsent(node, new ArrayList<>());

        if(neighbour != null) {
            adjList.putIfAbsent(neighbour, new ArrayList<>());
            adjList.get(node).add(neighbour);
            adjList.get(neighbour).add(node);
        }

        buildGraphAndCollectLeafNodes(adjList, leaves, node.left, node);
        buildGraphAndCollectLeafNodes(adjList, leaves, node.right, node);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();

        buildGraphAndCollectLeafNodes(adjList, leafNodes, root, null);

        int count = 0;

        for(TreeNode currentLeaf : leafNodes) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.offer(currentLeaf);
            visited.add(currentLeaf);

            for(int level = 0; level <= distance; ++level) {
                int size = queue.size();

                while(size-- > 0) {
                    TreeNode node = queue.poll();

                    // a leaf node but it is not equal to current leaf node
                    if(node != currentLeaf && leafNodes.contains(node)) {
                        count++;
                    }

                    for(TreeNode neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
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