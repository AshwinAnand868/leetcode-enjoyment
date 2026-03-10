class Solution {
    public int[] findErrorNums(int[] nums) {
        // whenever we have been given a range from 1 to n, we can 
        // use the numbers themselves as indices in the array

        int[] answer = new int[2]; // size 2 : duplicate and missing element

        int n = nums.length;

        for(int i = 0; i < nums.length; ++i) {
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                answer[0] = Math.abs(nums[i]); // duplicate element
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for(int i = 0; i < n; ++i) {
            if(nums[i] > 0) {
                answer[1] = i + 1;
            }
        }

        return answer;
    }
}