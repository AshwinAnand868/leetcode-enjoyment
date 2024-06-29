class Solution {
    
    /*
        3,2,4,7,6 9
        
        
    */
    public int[] twoSum(int[] nums, int target) {
        
        int[] indices = new int[2];
        
        // create a hashmap of the given unsorted array
        HashMap<Integer, Integer> numsHashMap = new HashMap<>();
        
        for(int j = 0; j < nums.length; j++) {
            int current = nums[j];
            Integer potentialExistingIndex = numsHashMap.get(current);
            
            if(potentialExistingIndex != null) {
                // means duplicate entry
                
                if(current * 2 == target) {
                    // duplicate values sums up to the target
                    indices[0] = potentialExistingIndex;
                    indices[1] = j;
                    return indices;
                }
            }
            numsHashMap.put(nums[j], j);
        }
        
        Arrays.sort(nums); //2,3,4
        
        for(int i = 0; i < nums.length; i++) {
            
            /*
                Subtract the current value from target
                and then search the difference in the nums array using binary search
                store the current value index and then if found the number then store
                its index and exit the loop
            */
            
            int current = nums[i];
            int difference = target - current;
            
            boolean result = binarySearch(nums, difference);
                        
            if(result == true) {
                indices[0] = numsHashMap.get(current);
                indices[1] = numsHashMap.get(difference);
                break;
            }
            
        }
        
        
        return indices;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        boolean returnValue = false;
        
        while(low <= high) {
            int midIdx = (low + high) / 2;
            int mid = nums[midIdx];
            
            if(mid == target) {
              returnValue = true;
              break;
            }
            else if(mid < target) {
                low = midIdx + 1;
            } else if(mid > target) {
                high = midIdx - 1;
            }
        }
        
        return returnValue;
    } 
}