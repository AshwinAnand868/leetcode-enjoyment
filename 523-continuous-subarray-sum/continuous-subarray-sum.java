class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // Reference: Code Story With MIK You Tube
        Map<Integer, Integer> remainderWithIndex = new HashMap<>();

        // storing the 0 as a key because the running sum can also be 
        // a multiple of K itself
        remainderWithIndex.put(0, -1);

        int runningSum = 0;

        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int remainder = runningSum % k;

            // if the map contains that remainder key 
            if(remainderWithIndex.containsKey(remainder)) {
                
                // check if the length of the subarray found is >= 2
                if(i - remainderWithIndex.get(remainder) >= 2) {
                    return true;
                }

            } else {
                // we just add the remainder value once
                // it doesn't get updated if we encounter the same remainder again
                // because we are considering the remainder index to be as far as
                // possible from i (current index)
                remainderWithIndex.put(remainder, i);
            }
        }

        // if there is still not a good subarray, then we return false
        return false;

    }
}