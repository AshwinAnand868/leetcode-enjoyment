class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int oddCount = 0;
        int previousCount = 0;

        int result = 0;

        int i = 0, j = 0;

        while(j < n) {
            if(nums[j] % 2 != 0) {
                oddCount++;
                previousCount = 0;
            }

            while(oddCount == k) {
                previousCount++;

                if(i < n && nums[i] % 2 != 0) {
                    oddCount--;
                }

                ++i;
            }

            result += previousCount;
            ++j;
        }




        // track the number of odd counts
        // Map<Integer, Integer> map = new HashMap<>();
        // int n = nums.length;
        // int oddCount = 0;
        // map.put(0, 1); // we have seen zeroes once initially
        // int i = 0, j = 0;
        // int result = 0;

        // while(j < n) {
        //     oddCount += (nums[j] % 2 == 0) ? 0 : 1;

        //     if(map.containsKey(oddCount - k)) {
        //         result += map.get(oddCount - k);
        //     }

        //     map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        //     j++;
        // }

        return result;
    }
}