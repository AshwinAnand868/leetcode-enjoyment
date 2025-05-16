class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> childToParentMap = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // a node can have only one parent
        for(int i = 0; i < n; ++i) {
            if(childToParentMap.containsKey(leftChild[i]) ||
                childToParentMap.containsKey(rightChild[i])) {
                return false;
            }

            if(leftChild[i] != -1) {
                childToParentMap.put(leftChild[i], i);
                adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(leftChild[i]);
            }

            if(rightChild[i] != -1) {
                childToParentMap.put(rightChild[i], i);
                adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(rightChild[i]);
            }

        }

        // one node exists without any parent called root
        int root = -1;
        for(int i = 0; i < n; ++i) {
            if(!childToParentMap.containsKey(i)) {
                if(root != -1) {
                    return false;
                }
                root = i;
            }
        }

        if(root == -1) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(root);
        visited[root] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int child : adjList.getOrDefault(node, Collections.emptyList())) {
                if(!visited[child]) {
                    visited[child] = true;
                    count++;
                    queue.add(child);
                }
            }
        }

        return count == n;
    }
}