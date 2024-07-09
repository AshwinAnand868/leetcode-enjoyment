class Solution {
    public int removeDuplicates(int[] nums) {
        
        // creating a hashmap to store the value and count for that
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // loop through the array to fill the map
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        System.out.println(map);
        
        // satisfy the first condition - which is to keep the first k elements (size of hashmap) to be unique
        for(int i = 0, j = 0; i < nums.length; i = i + map.get(nums[i]), j++) {
            nums[j] = nums[i];
        }
        
        // second condition to return k
        return map.size();
    }
}