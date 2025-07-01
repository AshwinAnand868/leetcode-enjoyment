class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; ++i) {
            if(!visited[i]) {
                dfs(i, n, visited, isConnected);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, int n, boolean[] visited, int[][] isConnected) {
        visited[node] = true;

        for(int j = 0; j < n; ++j) {
            if(isConnected[node][j] == 1 && !visited[j]) {
                dfs(j, n, visited, isConnected);
            }
        }
    }
}