class Solution {

    public static int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day); // Store travel days in a set
        }

        int lastDay = days[days.length - 1]; // Last travel day
        int[] dp = new int[lastDay + 1]; // DP array (only up to last travel day)

        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1]; // If no travel, cost stays the same
                continue;
            }

            // Take the minimum cost of the three ticket options
            dp[i] = Math.min(
                costs[0] + dp[Math.max(0, i - 1)],  // 1-day pass
                Math.min(
                    costs[1] + dp[Math.max(0, i - 7)],  // 7-day pass
                    costs[2] + dp[Math.max(0, i - 30)]  // 30-day pass
                )
            );
        }

        return dp[lastDay]; // The minimum cost from first to last travel day

    }

    // Top Down approach using memoization
    // public int calculate(int[] days, int[] costs, int index, int[] memo) {
    //     if(index >= days.length) {
    //         return 0;
    //     }

    //     if(memo[index] != -1) {
    //         return memo[index]; // return already cached results
    //     }

    //     int cost1 = costs[0] + calculate(days, costs, index + 1, memo);

    //     int nextIndex = index;
    //     while(nextIndex < days.length && days[nextIndex] < days[index] + 7) {
    //         nextIndex++;
    //     }

    //     int cost7 = costs[1] + calculate(days, costs, nextIndex, memo);

    //     nextIndex = index;
    //     while (nextIndex < days.length && days[nextIndex] < days[index] + 30) {
    //         nextIndex++;
    //     }

    //     int cost30 = costs[2] + calculate(days, costs, nextIndex, memo);

    //     memo[index] = Math.min(cost1, Math.min(cost7, cost30));

    //     return memo[index];
    // }

    // Recursive Approach - O(3^n) 
    // public int calculate(int[] days, int[] costs, int index, int currCost, int[] minCost) {
    //     if (index >= days.length) {
    //         minCost[0] = Math.min(minCost[0], currCost);
    //         return currCost;
    //     }

    //     // Try buying 1-day ticket
    //     calculate(days, costs, index + 1, currCost + costs[0], minCost);

    //     // Find next unpaid day after buying a 7-day ticket
    //     int nextIndex = index;
    //     while (nextIndex < days.length && days[nextIndex] < days[index] + 7) {
    //         nextIndex++;
    //     }
    //     calculate(days, costs, nextIndex, currCost + costs[1], minCost);

    //     // Find next unpaid day after buying a 30-day ticket
    //     nextIndex = index;
    //     while (nextIndex < days.length && days[nextIndex] < days[index] + 30) {
    //         nextIndex++;
    //     }
    //     calculate(days, costs, nextIndex, currCost + costs[2], minCost);

    //     return minCost[0];
    // }

    // public int mincostTickets(int[] days, int[] costs) {
    //     int[] memo = new int[days.length];
    //     Arrays.fill(memo, -1); // Fill memo array with -1 (indicating uncomputed values)
    //     return calculate(days, costs, 0, memo);

        // int[] minCost = new int[]{Integer.MAX_VALUE};
        // return calculate(days, costs, 0, 0, minCost);
    // }
}
