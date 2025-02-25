class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        int n = nums.length;

        for(int i = 0; i < n; ++i) {
            totalOnes += nums[i];
        }

        if(totalOnes == 0) return 0;
        if(n < 2) return 0;

        int currWindowOnes = 0;
        int maxOnesTogether = 0;

        int end = 0, start = 0;

        while(start < n) {
            currWindowOnes += nums[end % n];


            if((end - start + 1) == totalOnes || 
                (start > end && Math.abs(end - start) == totalOnes)) {

                maxOnesTogether = Math.max(maxOnesTogether, currWindowOnes);

                if(nums[start] == 1) {
                    currWindowOnes--;
                }

                start++;
            }
            end++;
        }

        return totalOnes - maxOnesTogether;
    }
}