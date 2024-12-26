class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            int secondNum = target - nums[i];

            if(map.containsKey(secondNum)) {
                indices[0] = i;
                indices[1] = map.get(secondNum);
            } else {
                map.put(nums[i], i);
            }
        }

        return indices;
    }
}