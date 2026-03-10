class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);  // edge from b → a
        }

        int[] vis = new int[n];
        int[] pathVis = new int[n];
        List<Integer> topo = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            if(vis[i] == 0) {
                if(dfs(i, adj, vis, pathVis, topo)) { // detected a cycle
                    return new int[0];
                }
            }
        }

        Collections.reverse(topo);
        return topo.stream().mapToInt(i -> i).toArray();
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       int[] vis, int[] pathVis, List<Integer> topo) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                if (dfs(neighbor, adj, vis, pathVis, topo)) return true;
            } else if (pathVis[neighbor] == 1) {
                return true; // cycle found
            }
        }

        pathVis[node] = 0; // backtrack
        topo.add(node);   // post-order for topo sort
        return false;
    }

}