class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
       
        int[] dp = new int[n];
        Arrays.sort(nums);

        Arrays.fill(dp, 1);
        int maxLen = 1;
        int lastIndex = 0;

        int[] hash = new int[n]; // tracking the previous indices of element

        for (int i = 0; i < n; ++i) {
            hash[i] = i; // putting the current index initially
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j; // j points at the second last element in the sequence
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }

        Collections.reverse(list);
        return list;
    }
}