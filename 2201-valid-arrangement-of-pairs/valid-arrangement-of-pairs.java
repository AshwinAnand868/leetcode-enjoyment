class Solution {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    private List<Integer> eulerPath = new ArrayList<>();

    private void dfs(int node) {
        //if that node is in the map and there are its neighbours left to process
        while(adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove(adj.get(node).size() - 1);
            dfs(nextNode);
        }

        eulerPath.add(node);
    }

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        // building indegree and outdegree maps
        for(int[] edge: pairs) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        int startNode = pairs[0][0];

        for(int node : adj.keySet()) {
            if(outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        dfs(startNode);

        Collections.reverse(eulerPath);
        int[][] result = new int[eulerPath.size() - 1][2];
        for (int i = 0; i < eulerPath.size() - 1; i++) {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i + 1);
        }

        return result;
    }
}