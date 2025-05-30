class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int i = 0, j = 0, maxLength = 0, n = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        while(j < n) {
            while(!maxDeque.isEmpty() && maxDeque.peekLast() < nums[j]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(nums[j]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[j]) {
                minDeque.pollLast();
            }

            minDeque.offerLast(nums[j]);

            while(maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if(maxDeque.peekFirst() == nums[i]) {
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst() == nums[i]) {
                    minDeque.pollFirst();
                }
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;

        // TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        // while(j < n) {
        //     treeMap.put(nums[j], treeMap.getOrDefault(nums[j], 0) + 1);

        //     while(treeMap.lastKey() - treeMap.firstKey() > limit) {
        //         treeMap.put(nums[i], treeMap.get(nums[i]) - 1);
        //         if(treeMap.get(nums[i]) == 0) {
        //             treeMap.remove(nums[i]);
        //         }
        //         i++;
        //     }

        //     maxLength = Math.max(maxLength, j - i + 1);
        //     j++;
        // }

        // return maxLength;

        // PriorityQueue<int[]> maxPq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        // PriorityQueue<int[]> minPq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        // int i = 0, j = 0, maxLength = 0, n = nums.length;

        // while(j < n) {
        //     maxPq.offer(new int[] {nums[j], j});
        //     minPq.offer(new int[] {nums[j], j});

        //     while(maxPq.peek()[0] - minPq.peek()[0] > limit) {
        //         i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;

        //         while(maxPq.peek()[1] < i) {
        //             maxPq.poll();
        //         }

        //         while (minPq.peek()[1] < i) {
        //             minPq.poll();
        //         }


        //     }
        //     maxLength = Math.max(maxLength, j - i + 1);
        //     j++;
        // }

        // return maxLength;
    }
}