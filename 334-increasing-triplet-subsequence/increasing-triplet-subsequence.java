class Solution {
    public boolean increasingTriplet(int[] nums) {
        int num3 = 0;
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; ++i) {
            num3 = nums[i];

            if(num3 <= num1) {
                num1 = num3;
            } else if(num3 <= num2) {
                num2 = num3;
            } else {
                return true;
            }
        }

        return false;
    }
}