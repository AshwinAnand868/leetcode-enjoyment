class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int n = nums.length;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        // List<Integer> maxElems = new ArrayList<>();
        int[] maxElems = new int[n - k + 1];
        // we maintain a deque for storing elements in the backside
        // but dq doesn't maintain any order, so we will store
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;

        for(int j = 0; j < n; ++j) {
            
            // if the peek index goes out of window remove
            while(!dq.isEmpty() && dq.peekFirst() < i) {
                dq.pollFirst();
            }

            // smaller elements than current one is not needed
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[j]) {
                dq.pollLast();
            }

            dq.offerLast(j);

            if (j - i + 1 == k) {
                maxElems[index++] = nums[dq.peekFirst()];
                i++;
            }
            
            // remove elements

            // pq.offer(new int[] {nums[j], j});

            // if(j - i + 1 == k) {
            //     while(pq.size() > 0 && pq.peek()[1] < (j - k + 1)) {
            //         pq.poll();
            //     }

            //     maxElems.add(pq.peek()[0]);
            //     ++i;
            // }
        }

        return maxElems;
    }
}