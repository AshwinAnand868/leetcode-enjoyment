class Solution {
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int count = 1, longestCount = 1;

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int y = i;

                while (set.contains(y + 1)) {
                    count++;
                    y++;
                }
            }

            longestCount = Math.max(count, longestCount);
            count = 1;
        }

        return longestCount;

        // if (nums.length == 0) {
        // return 0;
        // }

        // PriorityQueue<Integer> minNums = new PriorityQueue<Integer>();

        // for (int i = 0; i < nums.length; ++i) {
        // minNums.offer(nums[i]);
        // }

        // int count = 1;
        // int maxCount = 1;

        // int prevElement = minNums.poll();

        // while (!minNums.isEmpty()) {

        // int nextElement = minNums.poll();

        // if (prevElement == nextElement) {
        // continue;
        // }

        // if (prevElement + 1 == nextElement) {
        // count++;
        // } else {
        // count = 1;
        // }

        // maxCount = Math.max(maxCount, count);
        // prevElement = nextElement;
        // }

        // return maxCount;
    }
}