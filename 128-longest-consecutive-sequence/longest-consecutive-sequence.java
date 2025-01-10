class Solution {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minNums = new PriorityQueue<Integer>();

        for (int i = 0; i < nums.length; ++i) {
            minNums.offer(nums[i]);
        }

        int count = 1;
        int maxCount = 1;

        int prevElement = minNums.poll();

        while (!minNums.isEmpty()) {

            int nextElement = minNums.poll();

            if (prevElement == nextElement) {
                continue;
            }

            if (prevElement + 1 == nextElement) {
                count++;
            } else {
                count = 1;
            }

            maxCount = Math.max(maxCount, count);
            prevElement = nextElement;
        }

        return maxCount;
    }
}