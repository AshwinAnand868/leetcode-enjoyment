class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> terminalNodes = new HashSet<>();
        Set<Integer> safeNodes = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            if (graph[i].length == 0) {
                terminalNodes.add(i);
            }
        }

        safeNodes.addAll(terminalNodes);

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!dfs(i, graph, vis, pathVis, terminalNodes, safeNodes)) {
                safeNodes.add(i);
            }
        }

        List<Integer> result = new ArrayList<>(safeNodes);
        Collections.sort(result); // problem requires sorted order
        return result;
    }

    private boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis,
                        Set<Integer> terminalNodes, Set<Integer> safeNodes) {

        vis[node] = true;
        pathVis[node] = true;

        for (int neighbour : graph[node]) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, graph, vis, pathVis, terminalNodes, safeNodes)) {
                    return true; // cycle found
                } else {
                    safeNodes.add(neighbour); // mark safe
                }
            } else if (pathVis[neighbour]) {
                return true; // cycle found
            }
        }

        pathVis[node] = false;
        return false; // no cycle
    }
}
