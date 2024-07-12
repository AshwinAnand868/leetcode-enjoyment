class Solution {
    public int removeElement(int[] nums, int val) {
        int nextUniqueIndex = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[nextUniqueIndex] = nums[i];
                nextUniqueIndex++;
            }
        }
        
        return nextUniqueIndex;
    }
}