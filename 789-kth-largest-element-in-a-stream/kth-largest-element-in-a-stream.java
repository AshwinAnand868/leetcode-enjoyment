class KthLargest { 

    int k;
    PriorityQueue<Integer> minPq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minPq = new PriorityQueue<>();
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minPq.offer(val);
        if(minPq.size() > k) {
            minPq.poll();
        }

        return minPq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */