class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer> stonesSet = new HashSet<>();

        for(int integer: stones) {
            stonesSet.add(integer);
        }

        Map<String, Boolean> memo = new HashMap<>();

        return canCrossHelper(stonesSet, stones[stones.length - 1], 0, 0, memo);
    }

    public boolean canCrossHelper(Set<Integer> stonesSet, int target, int position, int lastJump, Map<String, Boolean> memo) {
        if(position == target) { // frog reached the target (last) stone
            return true;
        }

        String key = position + "," + lastJump;

        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        for(int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if(jump > 0) {
                int nextPosition = position + jump; // nextPosition
                if (stonesSet.contains(nextPosition)) {
                    if (canCrossHelper(stonesSet, target, nextPosition, jump, memo)) {
                        memo.put(key, true);
                        return true;
                    }
                }
            }
        }

        memo.put(key, false);
        return false;
    }
}