import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        // Build maps manually
        for (int i = 0; i < n; i++) {
            int r = stones[i][0];
            int c = stones[i][1];

            // Row map
            if (!rowMap.containsKey(r)) {
                rowMap.put(r, new ArrayList<>());
            }
            rowMap.get(r).add(i);

            // Column map
            if (!colMap.containsKey(c)) {
                colMap.put(c, new ArrayList<>());
            }
            colMap.get(c).add(i);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, stones, visited, rowMap, colMap);
                components++;
            }
        }

        return n - components;
    }

    private void dfs(int i, int[][] stones, boolean[] visited,
                     Map<Integer, List<Integer>> rowMap,
                     Map<Integer, List<Integer>> colMap) {

        visited[i] = true;

        int r = stones[i][0];
        int c = stones[i][1];

        // Visit all stones in same row
        List<Integer> sameRow = rowMap.get(r);
        if (sameRow != null) {
            for (int nei : sameRow) {
                if (!visited[nei]) {
                    dfs(nei, stones, visited, rowMap, colMap);
                }
            }
        }

        // Visit all stones in same column
        List<Integer> sameCol = colMap.get(c);
        if (sameCol != null) {
            for (int nei : sameCol) {
                if (!visited[nei]) {
                    dfs(nei, stones, visited, rowMap, colMap);
                }
            }
        }
    }
}