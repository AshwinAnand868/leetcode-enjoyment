class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        
        // maximum elements that can occur more than n / 3 times are only two
        // elements for any given array
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            if(count1 == 0 && element2 != nums[i]) {
                count1 = 1;
                element1 = nums[i];
            } else if(count2 == 0 && element1 != nums[i]) {
                count2 = 1;
                element2 = nums[i];
            } else if(nums[i] == element1) {
                count1++;
            } else if(nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        
        count1 = 0;
        count2 = 0;
        for(int elem : nums) {
            if(elem == element1) {
                count1++;
            }
            if(elem == element2) {
                count2++;
            }
        }
        
        
        List<Integer> res = new ArrayList<>();

        if(count1 > (nums.length / 3)) {
            res.add(element1);
        }
        
        if(count2 > (nums.length / 3)) {
            res.add(element2);
        }
        
        return res;
    }
}