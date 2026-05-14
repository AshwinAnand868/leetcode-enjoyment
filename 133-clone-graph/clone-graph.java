/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return node;

        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        // map each and every node to just a single cloned node
        map.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            for(Node neighbour : n.neighbors) {
                if(!map.containsKey(neighbour)) {
                    map.put(neighbour, new Node(neighbour.val));
                    queue.offer(neighbour);
                }
                // connect new node with its new neighbours
                map.get(n).neighbors.add(map.get(neighbour));
            }

        }

        return map.get(node);
    }
}