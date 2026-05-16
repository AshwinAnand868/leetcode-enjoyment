class Solution {

    public void dfs(int[][] isConnected, int node, int n, boolean[] visited) {
        visited[node] = true;

        for(int i = 0; i < n; ++i) {
            if(isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, i, n, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int countProvinces = 0;

        for(int i = 0; i < n; ++i) {
            if(!visited[i]) {
                dfs(isConnected, i, n, visited);
                countProvinces++;
            }
        }

        return countProvinces;
    }
}