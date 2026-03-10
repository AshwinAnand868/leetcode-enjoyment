class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < gifts.length; ++i) {
            pq.add(gifts[i]);
        }
        
        // calculate square root of numbers only k times
        for(int i = 0; i < k; ++i) {
            pq.add((int) Math.sqrt(pq.remove()));
        }
        
        //calculate sum
        for(int i = 0; i < gifts.length; ++i) {
            sum += pq.remove();
        }
        
        return sum;
    }
}