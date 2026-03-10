class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;

        List<Integer> pairSum = new ArrayList<>();
        int m = n - 1;

        for(int i = 0; i < m; ++i) {
            pairSum.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(pairSum);

        long maxSum = 0;
        long minSum = 0;

        for(int i = 0; i < k - 1; ++i) {
            minSum += pairSum.get(i);
            maxSum += pairSum.get(m - i - 1);
        }

        return maxSum - minSum;
    }
}