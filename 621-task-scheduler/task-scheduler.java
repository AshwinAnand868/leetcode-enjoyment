class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task : tasks) {
            freq[task - 'A']++;
        }

        // creating a max heap to maintain the most frequent task at the top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int f : freq) {
            if(f > 0) {
                maxHeap.offer(f);
            }
        }

        // queue for maintaing count and 
        Queue<int[]> cooldownQ = new LinkedList<>();

        int time = 0;

        // continue processing until priority queue is not empty or cool down queue
        while(!maxHeap.isEmpty() || !cooldownQ.isEmpty()) {
            
            time++;

            if(!cooldownQ.isEmpty() && cooldownQ.peek()[1] <= time) { // the top most task in the queue has been cooled down - ready to processed task
                maxHeap.offer(cooldownQ.poll()[0]);
            }
            if(!maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                if(current - 1 > 0) {
                    cooldownQ.offer(new int[] {current - 1, time + n + 1});
                }
            }
        }


        return time;
    }
}