import java.util.*;

class Solution {
    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {

        int INF = (int)1e9;

        // Distance matrix for 26 letters
        int[][] dist = new int[26][26];

        // Initialize
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Fill direct conversions
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';

            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        // Floyd-Warshall
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Calculate total cost
        long total = 0;

        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if (dist[from][to] == INF) {
                return -1;
            }

            total += dist[from][to];
        }

        return total;
    }
}
