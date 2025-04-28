class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // track the number of odd counts
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int oddCount = 0;
        map.put(0, 1); // we have seen zeroes once initially
        int i = 0, j = 0;
        int result = 0;

        while(j < n) {
            oddCount += (nums[j] % 2 == 0) ? 0 : 1;

            if(map.containsKey(oddCount - k)) {
                result += map.get(oddCount - k);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
            j++;
        }

        return result;
    }
}