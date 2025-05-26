class Solution {
    public boolean canCross(int[] stones) {

        // store stone with jump sizes to reach that stone
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for(int stone : stones) {
            dp.put(stone, new HashSet<>()); // initially empty to reach each stone
        }

        dp.get(0).add(0);

        for(int stone : stones) {
            for(int jump : dp.get(stone)) {
                for(int step = jump - 1; step <= jump + 1; step++) {
                    if(step > 0 && dp.containsKey(stone + step)) {
                        dp.get(stone + step).add(step);
                    }
                }
            }
        }

        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}