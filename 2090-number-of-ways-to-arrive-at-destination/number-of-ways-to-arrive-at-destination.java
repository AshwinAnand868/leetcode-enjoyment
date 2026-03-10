class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time}); // bidirectional
        }

        // Priority queue of {time, node}
        Queue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        queue.offer(new long[]{0, 0});

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        while (!queue.isEmpty()) {
            long[] curr = queue.poll();
            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) continue;

            for (int[] nbr : adj.get(node)) {
                int nbrNode = nbr[0];
                int nbrTime = nbr[1];
                long totalTime = time + nbrTime;

                if (totalTime < dist[nbrNode]) {
                    dist[nbrNode] = totalTime;
                    ways[nbrNode] = ways[node];
                    queue.offer(new long[]{totalTime, nbrNode});
                } else if (totalTime == dist[nbrNode]) {
                    ways[nbrNode] = (ways[nbrNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
