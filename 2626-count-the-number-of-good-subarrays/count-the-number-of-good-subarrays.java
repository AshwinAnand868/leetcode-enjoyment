class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        long pairCnt = 0;
        int j = 0; // left or tail

        for(int i = 0; i < nums.length; i++) { // head or right

            map.merge(nums[i], 1, Integer::sum);
            pairCnt += map.get(nums[i]) - 1;

            while(pairCnt >= k) {
                result += nums.length - i; // total number of good subarrays till now
                map.merge(nums[j], -1, Integer::sum);
                pairCnt -= map.get(nums[j]);
                if(map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }

        }

        return result;
    }
}