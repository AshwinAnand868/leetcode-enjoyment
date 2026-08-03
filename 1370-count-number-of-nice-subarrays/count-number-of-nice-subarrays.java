class Solution {

    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;

        int left = 0;
        int oddCount = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // our all valid subarrays ending at right
            ans += right - left + 1;
        }

        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}