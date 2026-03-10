class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixOccMap = new HashMap<>();
        prefixOccMap.put(0, 1); // add a dummy sum occurrence for 0 sum
        
        int prefixSum = 0;
        int count = 0;
        
        for(int right = 0; right < nums.length; ++right) {
            prefixSum += nums[right];

            if(prefixOccMap.containsKey(prefixSum - k)) {
                count += prefixOccMap.get(prefixSum - k); 
            }

            prefixOccMap.put(prefixSum, prefixOccMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}