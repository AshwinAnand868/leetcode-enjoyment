class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answers = new int[queries.length];
        int evenSum = 0;
        int n = nums.length;

        for(int i = 0; i < n; ++i) {
            if(nums[i] % 2 == 0) {
                evenSum += nums[i];
            }
        }

        for(int i = 0; i < queries.length; ++i) {
            int currVal = queries[i][0];
            int currIndex = queries[i][1];

            if(nums[currIndex] % 2 == 0) {
                evenSum -= nums[currIndex];
            }

            nums[currIndex] += currVal;
            if(nums[currIndex] % 2 == 0) {
                evenSum += nums[currIndex];
            }

            answers[i] = evenSum;
        }

        return answers;
    }
}