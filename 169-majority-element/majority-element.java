class Solution {
    public int majorityElement(int[] nums) {

        int majority = -1;
        int count = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(count == 0) {
                majority = nums[i];
                count++;
            } else if(majority == nums[i]) {
                count++;
            } else {
                count--;
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