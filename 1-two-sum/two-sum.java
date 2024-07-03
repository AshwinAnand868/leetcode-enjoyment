class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if(numsHashMap.containsKey(diff)) {
                return new int[] {numsHashMap.get(diff), i};
            }
            
            numsHashMap.put(nums[i], i);
        }
        
        return new int[]{};
        
    }
}