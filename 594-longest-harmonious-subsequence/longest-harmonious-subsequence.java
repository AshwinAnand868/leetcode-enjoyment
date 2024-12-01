class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int longestHSLength = 0;
        
        for(int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Integer key: counter.keySet()) {
            if(counter.containsKey(key + 1)) {
                longestHSLength = Math.max(longestHSLength, counter.get(key) + counter.get(key + 1));
            }
        }
        
        return longestHSLength;
    }
}