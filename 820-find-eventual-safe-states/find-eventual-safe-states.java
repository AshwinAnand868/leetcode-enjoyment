class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Reverse the graph: for each edge u -> v, add u to adjRev[v]
        for (int u = 0; u < n; ++u) {
            for (int v : graph[u]) {
                adjRev.get(v).add(u);
                indegree[u]++;
            }
        }

        // Start with all terminal nodes (original terminal → now indegree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            for (int prev : adjRev.get(node)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}
