class Solution {

    public void dfs(List<List<Integer>> adjList, int curr, int destination, 
        boolean[] visited) {
            visited[curr] = true;

            if(curr == destination) return;

            for(int i : adjList.get(curr)) {
                if(!visited[i])
                    dfs(adjList, i, destination, visited);
            }
        }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();

        int edgeCount = edges.length;

        for(int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edgeCount; ++i) {
            int edge1 = edges[i][0];
            int edge2 = edges[i][1];

            // undirectional
            adjList.get(edge1).add(edge2);
            adjList.get(edge2).add(edge1);
        }

        boolean[] visited = new boolean[n];

        dfs(adjList, source, destination, visited);

        return visited[destination];
    }
}