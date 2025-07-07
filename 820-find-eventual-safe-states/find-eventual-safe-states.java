class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] isSafe = new boolean[n];

        for(int i = 0; i < n; ++i) {
            dfs(i, graph, vis, pathVis, isSafe);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            if(isSafe[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] isSafe) {
        if(vis[node]) return isSafe[node];

        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour: graph[node]) {
            if(!vis[neighbour]) {
                if(!dfs(neighbour, graph, vis, pathVis, isSafe)) return false;
            } else if(pathVis[neighbour]) {
                // cycle found
                return false;
            }
        }

        pathVis[node] = false;
        isSafe[node] = true;
        return true;
    }
}