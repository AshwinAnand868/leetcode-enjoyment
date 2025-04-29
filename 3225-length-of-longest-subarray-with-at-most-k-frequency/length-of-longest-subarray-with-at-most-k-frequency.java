class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length, maxLen = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while(j < n) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);

            while(i < j && freqMap.get(nums[j]) > k) {
                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}