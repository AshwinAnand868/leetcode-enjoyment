class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int i = 0, j = 0, maxLength = 0, n = nums.length;

        while(j < n) {
            maxPq.offer(new int[] {nums[j], j});
            minPq.offer(new int[] {nums[j], j});

            while(maxPq.peek()[0] - minPq.peek()[0] > limit) {
                i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;

                while(maxPq.peek()[1] < i) {
                    maxPq.poll();
                }

                while (minPq.peek()[1] < i) {
                    minPq.poll();
                }


            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}