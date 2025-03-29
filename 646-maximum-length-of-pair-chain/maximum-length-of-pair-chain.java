class Solution {

    public int findLongestChain(int[][] pairs, int currentIndex, int previousIndex, int[][] dp) {
            if(currentIndex >= pairs.length) {
                return 0;
            }

            if(previousIndex != -1 && dp[currentIndex][previousIndex] != -1) {
                return dp[currentIndex][previousIndex];
            }

            int take = 0;
            if(previousIndex == -1 || pairs[currentIndex][0] > pairs[previousIndex][1]) {
                take = findLongestChain(pairs, currentIndex + 1, currentIndex, dp) + 1;
            }

            int skip = findLongestChain(pairs, currentIndex + 1, previousIndex, dp);

            if(previousIndex != -1) {
                dp[currentIndex][previousIndex] = Math.max(take, skip);
            }

            return Math.max(take, skip);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]); 
        int[][] dp = new int[pairs.length][pairs.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findLongestChain(pairs, 0, -1, dp);

    }
}