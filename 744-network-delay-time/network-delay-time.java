class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1, t = time[2];
            adj.get(u).add(new int[]{v, t});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{0, k - 1}); // {time, node}

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int time = curr[0];
            int node = curr[1];

            for (int[] nbr : adj.get(node)) {
                int nbrNode = nbr[0];
                int nbrTime = nbr[1];

                if (dist[node] + nbrTime < dist[nbrNode]) {
                    dist[nbrNode] = dist[node] + nbrTime;
                    queue.offer(new int[]{dist[nbrNode], nbrNode});
                }
            }
        }

        int max = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1;
            max = Math.max(max, d);
        }

        return max;
    }
}
