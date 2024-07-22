class Solution {
    public int climbStairs(int n) {
        Map<Integer,Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if(n <= 1) {
            return 1;
        }
        
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int result = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo.put(n, result);
        
        return result;
    }
}