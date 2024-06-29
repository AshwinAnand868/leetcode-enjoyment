class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();
        int[] indices = new int[2];
             
        for(int i = 0; i < nums.length; i++) {
            Integer potentialExistingIndex = numsHashMap.get(nums[i]);
            
            if(potentialExistingIndex != null) {
                if(nums[i] * 2 == target) {
                    indices[0] = potentialExistingIndex;
                    indices[1] = i;
                    System.out.println(potentialExistingIndex);
                    return indices;
                }
            }
            numsHashMap.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if(numsHashMap.containsKey(diff) && numsHashMap.get(diff) != i) {
                indices[0] = i;
                indices[1] = numsHashMap.get(diff);
                break;
            }
        }
        
        return indices;
        
    }
}