class Solution {
    public int majorityElement(int[] nums) {

        // Boyer-Moore Majority Vote Algorithm

        int majority = nums[0];
        int n = nums.length;
        int count = 1;

        for(int i = 1; i < n; ++i) {
            if(count == 0) { // a fresh cycle
                majority = nums[i]; // update majority
                count++; // update count
            } else if(nums[i] == majority) // if current element is majority
            {
                count++; // continue incrementing the count
            } else {
                count--; // decrement count if current is not majority
            }
        }


        return majority;

        // int majorityElement = 0;
        // int n = nums.length;

        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < n; ++i) {
        //     map.merge(nums[i], 1, Integer::sum);
        // }

        // int halfN = n / 2;
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() > halfN) {
        //         majorityElement = entry.getKey();
        //     }
        // }

        // return majorityElement;
    }
}