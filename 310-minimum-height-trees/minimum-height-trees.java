class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(0);
            return result;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {

            int size = queue.size();

            remainingNodes -= size;

            for (int i = 0; i < size; i++) {

                int leaf = queue.poll();

                for (int neighbour : adj.get(leaf)) {

                    degree[neighbour]--;

                    if (degree[neighbour] == 1) {
                        queue.offer(neighbour);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}