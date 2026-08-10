class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        List<Integer> maxElems = new ArrayList<>();

        for(int j = 0; j < n; ++j) {
            pq.offer(new int[] {nums[j], j});

            if(j - i + 1 == k) {
                while(pq.size() > 0 && pq.peek()[1] < (j - k + 1)) {
                    pq.poll();
                }

                maxElems.add(pq.peek()[0]);
                ++i;
            }
        }

        return maxElems.stream().mapToInt(elem -> elem).toArray();
    }
}