class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int majorityCount = (int) Math.floor(n / 3);

        for(int i = 0; i < nums.length; ++i) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> keyValue : map.entrySet()) {
            int key = keyValue.getKey();
            int value = keyValue.getValue();

            if(value > majorityCount) {
                result.add(key);
            }
        }

        return result;
    }
}