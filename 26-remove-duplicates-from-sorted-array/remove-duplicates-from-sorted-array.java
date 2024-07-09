class Solution {
    // premature optimizstion is the root cuase of all evil
    public int removeDuplicates(int[] nums) {
        
        // creating a hashmap to store the value and count for that
        HashMap<Integer, Integer> map = new HashMap<>();
        int nextUniqueIndex = 0;
        
        // loop through the array to fill the map
        for(int i = 0; i < nums.length; i++) {
            
            if(map.containsKey(nums[i])) {
                // not unique
                // map.put(nums[i], map.get(nums[i]) + 1);
                
            } else {
                // unique
                map.put(nums[i], 1);
                nums[nextUniqueIndex] = nums[i];
                nextUniqueIndex++;
            }
            
        }
                
        // satisfy the first condition - which is to keep the first k elements (size of hashmap) to be unique
//         for(int i = 0, j = 0; i < nums.length; i = i + map.get(nums[i]), j++) {
//             nums[j] = nums[i];
//         }
        
        // second condition to return k
        return map.size();
    }
}