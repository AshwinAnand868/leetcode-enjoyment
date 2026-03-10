class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (i >= k - 1) {
                double currentAvg = runningSum / (k * 1.0);
                maxAvg = Math.max(maxAvg, currentAvg);
                runningSum -= nums[i - (k - 1)];
            }
        }
        
        return maxAvg;
    }
}
