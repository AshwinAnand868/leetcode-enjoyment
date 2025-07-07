class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = numCourses;

        for(int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites) {
           int u = edge[0], v = edge[1];
           adj.get(u).add(v);
        }

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];

        for(int i = 0; i < n; ++i) {
            if(!vis[i]) {
                // if there is a cycle then we will never be able to finish all courses
                if(dfs(i, adj, vis, pathVis)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true; // mark it as visited
        pathVis[node] = true; // mark it for current path

        for(int neighbour : adj.get(node)) {
            if(!vis[neighbour]) {
                if(dfs(neighbour, adj, vis, pathVis)) return true; // propagate the value
            } else if(pathVis[neighbour]) {
                return true;
            }
        }

        // restore path vis
        pathVis[node] = false;
        return false;
    }
}