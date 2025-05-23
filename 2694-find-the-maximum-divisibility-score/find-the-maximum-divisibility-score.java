class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int divisionScore = Integer.MIN_VALUE;
        int value = 0;

        for(int i = 0; i < divisors.length; ++i) {
            int currScore = 0;
            for(int j = 0; j < nums.length; ++j) {
                if(nums[j] % divisors[i] == 0) {
                    currScore++;
                }
            }

            if(currScore > divisionScore) {
                value = divisors[i];
                divisionScore = currScore;
            } else if(currScore == divisionScore) {
                if(divisors[i] < value) {
                    value = divisors[i];
                }
            }
        }
        return value;
    }
}