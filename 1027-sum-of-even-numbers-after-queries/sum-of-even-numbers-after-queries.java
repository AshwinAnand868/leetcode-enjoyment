class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int j = 0;

        // calculate initial sum of even values
        int sumEven = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] % 2 == 0) {
                sumEven += nums[i];
            }
        }

        for(int[] query : queries) {
            int val = query[0];
            int index = query[1];

            int old = nums[index];

            if(old % 2 == 0) {
                sumEven -= old;
            }

            nums[index] = val + nums[index];

            if(nums[index] % 2 == 0) {
                sumEven += nums[index];
            }

            answer[j] = sumEven;

            // if(old % 2 != 0 && nums[index] % 2 == 0) {
            //     answer[j] = sumEvenInitial + nums[index];
            // } else if(old % 2 == 0 && nums[index] % 2 != 0) {
            //     answer[j] = sumEvenInitial - old;
            // } else if(old % 2 == 0 && nums[index] % 2 == 0) {
            //     sumEvenInitial -= old;
            //     sumEvenInitial += nums[index];
            //     answer[j] = sumEvenInitial;
            // }

            // calculate the sum of even values of nums
            // int sum = 0;
            // for(int i = 0; i < nums.length; ++i) {
            //     if(nums[i] % 2 == 0) {
            //         sum += nums[i];
            //     }
            // }

            ++j;

        }

        return answer;
    }
}