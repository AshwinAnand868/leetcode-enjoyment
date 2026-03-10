public class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        this.rank = new int[n + 1];
        this.size = new int[n + 1];
        Arrays.fill(size, 1);
        this.parent = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            this.parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]); // path compression - resetting each parent to ultimate parent (the
                                                     // boss :>))
        }
        return parent[node];
    }

    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (px == py)
            return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public void unionBySize(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);

        if (px == py)
            return;

        if (size[px] > size[py]) {
            parent[py] = px;
            size[px] += size[py];
        } else {
            parent[px] = py;
            size[py] += size[px];
        }
    }

}

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int n = stones.length;
        for(int i = 0; i < n; ++i) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1); // total nodes passed

        for(int i = 0; i < n; ++i) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1];
            ds.unionBySize(nodeRow, nodeCol + maxRow + 1);
        }

        int cnt = 0;
        for(int i = 0; i <= maxRow + maxCol + 1; i++) {
            if(ds.parent[i] == i && ds.size[i] > 1) {
                cnt++;
            }
        }

        return n - cnt;
    }
}