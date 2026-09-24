class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dist = new int[n];

        for (int i = 0; i < n; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k - 1] = 0;

        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; ++i) {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            adjList.get(u - 1).add(new int[]{v - 1, wt});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, k - 1});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentDist = current[0];
            int node = current[1];

            for (int[] neigh : adjList.get(node)) {

                int neighNode = neigh[0];
                int neighDist = neigh[1];

                if (currentDist + neighDist < dist[neighNode]) {

                    dist[neighNode] = currentDist + neighDist;

                    pq.offer(new int[]{
                        dist[neighNode],
                        neighNode
                    });
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; ++i) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}