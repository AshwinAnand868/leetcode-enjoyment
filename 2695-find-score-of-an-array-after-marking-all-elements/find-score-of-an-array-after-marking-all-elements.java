class Pair {
    int num;
    int index;
    Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            if(a.num != b.num) return (a.num - b.num);
            else return (a.index - b.index);
        });
        
        for(int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }
        
        boolean[] marked = new boolean[n];
        
        long sum = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            
            Pair p = pq.poll();
            int currNum = p.num;
            int currIdx = p.index;
            
            if(marked[currIdx]) continue; // skip the iteration
            
            sum += currNum;
            
            marked[currIdx] = true;
            
            if(currIdx > 0) marked[currIdx - 1] = true;
            if(currIdx < nums.length - 1) marked[currIdx + 1] = true;
            
            
        }
        
        return sum;
    }
}