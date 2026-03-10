class DisjointSet {
    int[] rank;
    int[] parent;
    DisjointSet(int n) {
        this.rank = new int[n];
        Arrays.fill(rank, 1);
        this.parent = new int[n];
        for(int i = 0; i < n; ++i) {
            parent[i] = i; // firstly node is parent of itself
        }
    }

    public int findParent(int x) {
        if(parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xp = findParent(x);
        int yp = findParent(y);

        if(xp == yp) return false; // union not successful as they are already connected

        if(rank[xp] > rank[yp]) {
            parent[yp] = xp;
        } else if(rank[yp] > rank[xp]) {
            parent[xp] = yp;
        } else {
            parent[yp] = xp;
            rank[xp]++;
        }

        return true;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1) return -1;

        int extraEdges = 0;
        int successfulUnions = 0;
        
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < connections.length; ++i) {
            int[] connection = connections[i];
            int u = connection[0], v = connection[1];
            if (!ds.union(u, v)) {
                extraEdges++;
            } else {
                successfulUnions++;
            }
        }

        int componentsCount = n - successfulUnions;
        int connectionsRequired = componentsCount - 1; // n - 1 components required
        
        return extraEdges >= connectionsRequired ? connectionsRequired : -1;
    }
}