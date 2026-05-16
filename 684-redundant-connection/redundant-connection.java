class Solution {

    public int find(int i, int[] parent) {
        if(i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    public void union(int u, int v, int[] parent) {
        int parentU = find(u, parent);
        int parentV = find(v, parent);

        if(parentU != parentV) {
            parent[parentV] = parentU;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // if we find a cycle, this is our culprit edge
            if(find(u, parent) == find(v, parent)) {
                return edge;
            }

            union(u, v, parent);
        }

        return new int[0];
    }
}