class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getNGoodSubarrays(nums, k) - getNGoodSubarrays(nums, k - 1);
    }

    public int getNGoodSubarrays(int[] nums, int k) {

        if(k < 0) return 0;

        int i = 0, j = 0, n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while(map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) <= 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            

            count += (j - i + 1);
            j++;
        }

        return count;
    }
}