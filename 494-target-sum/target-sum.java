class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return recursive(nums, 0, 0, target, map);
    }

    private int recursive(int[] nums, int currentIdx, int currentSum, int target, Map<String, Integer> map) {
        if(currentIdx == nums.length) {
            if(currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = Integer.toString(currentIdx) + "_" + Integer.toString(currentSum);

        if(map.containsKey(key)) {
            return map.get(key);
        }

        // exploring both possibilities for each integer
        int plus = recursive(nums, currentIdx + 1, currentSum + nums[currentIdx], target, map);
        int minus = recursive(nums, currentIdx + 1, currentSum - nums[currentIdx], target, map);

        map.put(key, plus + minus);
        return plus + minus;
    }
}