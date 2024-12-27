class Solution {
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        // Map<String, Integer> map = new HashMap<>();
        
        totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        return calcWays(nums, 0, 0, target, memo);
    }

    private int calcWays(int[] nums, int currentIdx, int currentSum, int target, int[][] memo) {
        if(currentIdx == nums.length) {
            if(currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        // String key = Integer.toString(currentIdx) + "_" + Integer.toString(currentSum);
        if(memo[currentIdx][currentSum + totalSum] != -1) {
            return memo[currentIdx][currentSum + totalSum]; // just a state
        }

        // if(map.containsKey(key)) {
        //     return map.get(key);
        // }

        // exploring both possibilities for each integer
        int plus = calcWays(nums, currentIdx + 1, currentSum + nums[currentIdx], target, memo);
        int minus = calcWays(nums, currentIdx + 1, currentSum - nums[currentIdx], target, memo);

        // map.put(key, plus + minus);
        memo[currentIdx][currentSum + totalSum] = plus + minus;
        return memo[currentIdx][currentSum + totalSum];
    }
}