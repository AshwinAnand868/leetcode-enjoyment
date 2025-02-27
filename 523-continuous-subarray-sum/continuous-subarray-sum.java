class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
                // Map to store remainder of running sum divided by k and its index
        Map<Integer, Integer> remainderWithIndex = new HashMap<>();

        // Store (0, -1) because a running sum itself can be a multiple of k
        remainderWithIndex.put(0, -1);

        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i]; // Update running sum
            int remainder = runningSum % k; // Compute remainder when divided by k

            // If we have seen this remainder before
            if (remainderWithIndex.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderWithIndex.get(remainder) >= 2) {
                    return true; // Found a valid subarray
                }
            } else {
                // Store the first occurrence of this remainder
                remainderWithIndex.put(remainder, i);
            }
        }

        // If no valid subarray is found, return false
        return false;
    }
}