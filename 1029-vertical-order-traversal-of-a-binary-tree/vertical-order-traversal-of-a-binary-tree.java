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

class Tuple {
    TreeNode node;
    int column;
    int level;

    Tuple(){}
    Tuple(TreeNode node, int column, int level) {
        this.node = node;
        this.column = column;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Using Level Order Traversal
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = 
            new TreeMap<>();

        while(!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode currNode = tuple.node;
            int col = tuple.column;
            int level = tuple.level;

            if(!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            if(!map.get(col).containsKey(level)) {
                map.get(col).put(level, new PriorityQueue<>());
            }

            map.get(col).get(level).offer(currNode.val);

            if(currNode.left != null) {
                queue.offer(new Tuple(currNode.left, col - 1, level + 1));
            }

            if(currNode.right != null) {
                queue.offer(new Tuple(currNode.right, col + 1, level + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> cols : map.values()) {
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodesVals : cols.values()) {
                while(!nodesVals.isEmpty()) {
                    result.get(result.size() - 1).add(nodesVals.poll());
                }
            }
        }

        return result;
    }
}