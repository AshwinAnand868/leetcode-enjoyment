class Solution {

    private int slidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0, count = 0;
        int n = nums.length;
        
        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);

                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            // formula to get number of subarray from i to j is j - i + 1
            count += j - i + 1;
            j++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }
}