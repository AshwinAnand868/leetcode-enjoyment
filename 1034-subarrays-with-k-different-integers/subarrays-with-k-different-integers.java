class Solution {
    private int subarraysWithAtMostElems(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int i = 0;
        int j = 0;

        int ans = 0;

        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            // if maps size become greater than k or at most window size
            while(map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);

                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            // number of subarrays ending at j is j - i + 1
            ans += j - i + 1;
            j++;
        }

        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostElems(nums, k) - subarraysWithAtMostElems(nums, k - 1);
    }
}