class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int j = 0;
        for(int[] query : queries) {
            int val = query[0];
            int index = query[1];

            nums[index] = val + nums[index];

            // calculate the sum of even values of nums
            int sum = 0;
            for(int i = 0; i < nums.length; ++i) {
                if(nums[i] % 2 == 0) {
                    sum += nums[i];
                }
            }

            answer[j] = sum;
            ++j;
        }

        return answer;
    }
}