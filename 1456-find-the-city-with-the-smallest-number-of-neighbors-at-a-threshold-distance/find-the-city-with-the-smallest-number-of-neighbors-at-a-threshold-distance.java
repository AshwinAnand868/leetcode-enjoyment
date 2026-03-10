class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; ++i) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2); // to prevent overflow
            graph[i][i] = 0; // node to the same node distance is 0
        }

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u][v] = w;
            graph[v][u] = w;
        }

        // Floyd-Warshall to calculate all-pairs shortest path
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int[] count = new int[n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i != j && graph[i][j] <= distanceThreshold) {
                    count[i]++; // stores the count of cities each node is connected to with in threshold distance
                }
            }
        }

        int minCount = Integer.MAX_VALUE;
        int result = -1;

        for(int i = 0; i < n; ++i) {
            if(minCount >= count[i]) { // checking equality because we need to return city with greatest number
                minCount = count[i];
                result = i;
            }
        }

        return result;
    }
}